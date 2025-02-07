package com.musinsa.product.core.service.item;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class PriceSummary {
    String categoryName;
    List<PriceSummaryItem> minItem;
    List<PriceSummaryItem> maxItem;
}
