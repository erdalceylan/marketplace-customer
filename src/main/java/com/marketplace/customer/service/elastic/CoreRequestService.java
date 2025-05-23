package com.marketplace.customer.service.elastic;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoreRequestService {

    private final CoreFeignService coreFeignService;

    CoreRequestService(
            CoreFeignService coreFeignService
    ){
        this.coreFeignService = coreFeignService;
    }

    public List<Object> getTopBrands(){
        return coreFeignService.getTopBrands();
    }

    public List<Object> getTopMerchants(){
        return coreFeignService.getTopMerchants();
    }
}
