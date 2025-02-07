package com.musinsa.product.core.service.item;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class PriceSummaryItem {
    String brandName;
    BigDecimal price;
}
