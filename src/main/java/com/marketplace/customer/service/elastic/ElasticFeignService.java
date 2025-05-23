package com.marketplace.customer.service.elastic;

import com.marketplace.customer.dto.request.search.ProductFilterRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "elastic-service", url = "${app.elastic-url}")
public interface ElasticFeignService {

    @GetMapping(value = "/products/{id}")
    Object getById(@PathVariable Long id);

    @PostMapping(value = "/products/aggregate")
    Object aggregate(@RequestBody ProductFilterRequestDTO productFilterRequestDTO);

    @GetMapping(value = "/suggests")
    List<Object> suggests(@RequestParam String q);

    @PostMapping(value = "/products/search")
    List<Object> search(@RequestBody ProductFilterRequestDTO productFilterRequestDTO);

}
