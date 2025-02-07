package com.musinsa.product.core.service.item;

import com.musinsa.product.core.domain.Brand;
import com.musinsa.product.core.domain.Category;
import com.musinsa.product.core.domain.Item;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.Map;

@Value
@Builder
public class BrandMinSummary {
    Brand brand;
    Map<Category, Item> itemByCategory;
    BigDecimal totalPrice;
}
