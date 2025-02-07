package com.musinsa.product.application.persistence.item;

import com.musinsa.product.core.domain.Category;
import com.musinsa.product.core.domain.Item;
import com.musinsa.product.core.service.item.MinItem;

import java.util.List;

public interface ItemRepository {
    List<MinItem> findMinPricedProductPerCategory();

    List<Item> findAll();

    List<Item> findAllByCategory(Category category);
}
