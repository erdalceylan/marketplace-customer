package com.marketplace.customer.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import java.io.IOException;

@Component
public class HeaderInterceptor implements HandlerInterceptor {

    @Value("${ANGULAR_HASH}")
    private String ANGULAR_HASH;


    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws IOException, ServletException {

        var isParentRequest = request.getAttribute("subRequest") == null;
        var isWebservice = request.getHeader("Webservice") != null;

        if (!isParentRequest) {
            return true;
        }

        if (request.getRequestURI().startsWith("/error")) {
            return true;
        }

        if (isWebservice) {
            response.addHeader("Angular-Hash", this.ANGULAR_HASH);
        }

        if (!isWebservice) {
            var redirectToDashboard = false;
            if (handler instanceof HandlerMethod) {
                Class<?> controllerClass = ((HandlerMethod) handler).getBeanType();
                if (controllerClass.isAnnotationPresent(RestController.class)) {
                    redirectToDashboard = true;
                }
            } else if (handler instanceof ResourceHttpRequestHandler) {
                redirectToDashboard = true;
            }
            if (redirectToDashboard) {
                request.getRequestDispatcher("/").forward(request, response);
                return false;
            }
        }

        request.setAttribute("subRequest", "ok");
        return true;
    }


}
