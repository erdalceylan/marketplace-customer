package com.marketplace.customer.service.elastic;

import com.marketplace.customer.dto.request.search.ProductFilterRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElasticRequestService {

    private final ElasticFeignService elasticFeignService;

    ElasticRequestService(
            ElasticFeignService elasticFeignService
    ){
        this.elasticFeignService = elasticFeignService;
    }

    public Object getByID(Long id) {
        return elasticFeignService.getById(id);
    }

    public Object aggregate(ProductFilterRequestDTO productFilterRequestDTO) {
        return elasticFeignService.aggregate(productFilterRequestDTO);
    }

    public List<Object> suggests(String q) {
        return elasticFeignService.suggests(q);
    }

    public List<Object> search(ProductFilterRequestDTO productFilterRequestDTO) {
        return elasticFeignService.search(productFilterRequestDTO);
    }
}
