package com.musinsa.product.application.persistence;

import com.musinsa.product.core.service.MinItem;
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
}
