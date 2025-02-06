package com.musinsa.product.core.service;

import com.musinsa.product.application.persistence.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional(readOnly = true)
    public MinItemSummary getMinPricePerCategory() {
        List<MinItem> minPricedItemsPerCategory = itemRepository.findMinPricedProductPerCategory();

        BigDecimal totalPrice = minPricedItemsPerCategory.stream()
                .map(MinItem::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return MinItemSummary.builder()
                .totalPrice(totalPrice)
                .detailList(minPricedItemsPerCategory)
                .build();
    }
}
