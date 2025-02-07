package com.musinsa.product.application.api.item.payload;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SaveItemRequest {
    private Long itemId;
    private String name;
    private BigDecimal price;
    private Long brandId;
    private Long categoryId;
}
