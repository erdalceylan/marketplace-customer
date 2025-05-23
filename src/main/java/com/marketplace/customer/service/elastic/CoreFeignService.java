package com.marketplace.customer.service.elastic;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "core-service", url = "${app.core-url}")
public interface CoreFeignService {

    @GetMapping(value = "/brands/top")
    List<Object> getTopBrands();

    @GetMapping(value = "/merchants/top")
    List<Object> getTopMerchants();

}
