package com.musinsa.product.application.persistence.item;

import com.musinsa.product.core.domain.Item;
import com.musinsa.product.core.service.item.MinItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ItemDao implements ItemRepository {

    private final ItemJpaRepository categoryJpaRepository;

    @Override
    public List<MinItem> findMinPricedProductPerCategory() {
        return categoryJpaRepository.findMinPricedProductPerCategory();
    }

    @Override
    public List<Item> findAll() {
        return categoryJpaRepository.findAll();
    }
}
