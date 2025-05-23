package com.marketplace.customer.controller;

import com.marketplace.customer.service.elastic.CoreRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController {

    private final CoreRequestService coreRequestService;

    BrandController(
            CoreRequestService coreRequestService
    ){
        this.coreRequestService = coreRequestService;
    }

    @GetMapping("/top")
    public ResponseEntity<List<Object>> product() {
        return ResponseEntity.ok(coreRequestService.getTopBrands());
    }
}
