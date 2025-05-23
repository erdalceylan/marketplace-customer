package com.marketplace.customer.controller;

import com.marketplace.customer.service.elastic.CoreRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/merchants")
public class MerchantController {

    private final CoreRequestService coreRequestService;

    MerchantController(
            CoreRequestService coreRequestService
    ){
        this.coreRequestService = coreRequestService;
    }

    @GetMapping("/top")
    public ResponseEntity<List<Object>> product() {
        return ResponseEntity.ok(coreRequestService.getTopMerchants());
    }
}
