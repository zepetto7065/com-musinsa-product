package com.musinsa.product.application.api.item;

import com.musinsa.product.application.api.item.payload.ItemConverter;
import com.musinsa.product.application.api.item.payload.ItemMinPricePerCategorySummaryResponse;
import com.musinsa.product.core.service.ItemService;
import com.musinsa.product.core.service.MinItemSummary;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;
    @GetMapping("/min-price-summary")
    public ResponseEntity<ItemMinPricePerCategorySummaryResponse> minPriceSummary(){
        MinItemSummary minPricePerCategory = itemService.getMinPricePerCategory();

        ItemMinPricePerCategorySummaryResponse response = ItemConverter.INSTANCE.map(minPricePerCategory);

        return ResponseEntity.ok(response);
    }
}
