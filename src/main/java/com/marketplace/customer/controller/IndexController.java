package com.marketplace.customer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Value("${ANGULAR_HASH}")
    private String ANGULAR_HASH;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("ANGULAR_HASH", ANGULAR_HASH);
        return "index";
    }
}
