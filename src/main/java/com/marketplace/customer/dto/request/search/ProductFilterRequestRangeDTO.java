package com.marketplace.customer.dto.request.search;

import lombok.Data;

@Data
public class ProductFilterRequestRangeDTO {
    private Long min;
    private Long max;
}
