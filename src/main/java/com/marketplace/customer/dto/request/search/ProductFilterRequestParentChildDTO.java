package com.marketplace.customer.dto.request.search;

import lombok.Data;

import java.util.List;

@Data
public class ProductFilterRequestParentChildDTO {
    private Long id;
    private List<Long> childIds;
}
