package com.marketplace.customer.controller;

import com.marketplace.customer.dto.request.search.ProductFilterRequestDTO;
import com.marketplace.customer.service.elastic.ElasticRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    private final ElasticRequestService elasticRequestService;

    SearchController(
            ElasticRequestService elasticRequestService
    ){
        this.elasticRequestService = elasticRequestService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> product(@PathVariable Long id) {

        return ResponseEntity.ok(elasticRequestService.getByID(id));
    }

    @PostMapping("/aggregate")
    public ResponseEntity<Object> aggregate(@RequestBody ProductFilterRequestDTO requestDTO) {

        return ResponseEntity.ok(elasticRequestService.aggregate(requestDTO));
    }

    @GetMapping("/suggests")
    public ResponseEntity<Object> aggregate(@RequestParam String q) {

        return ResponseEntity.ok(elasticRequestService.suggests(q));
    }

    @PostMapping("")
    public ResponseEntity<List<Object>> search(@RequestBody ProductFilterRequestDTO requestDTO) {

        return ResponseEntity.ok(this.elasticRequestService.search(requestDTO));
    }

    @GetMapping("")
    public ResponseEntity<Object> search() {
        return ResponseEntity.ok("");
    }
}
