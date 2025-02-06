package com.musinsa.product.application.persistence;

import com.musinsa.product.core.service.MinItem;
import com.musinsa.product.core.service.MinItemSummary;

import java.util.List;

public interface ItemRepository {
    List<MinItem> findMinPricedProductPerCategory();
}
