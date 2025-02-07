package com.musinsa.product.core.service.item;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;

@Value
@Builder
public class SingleBrandMinItemSummary {
    String brandName;
    BigDecimal totalPrice;
    List<SingleBrandMinItem> details;
}
