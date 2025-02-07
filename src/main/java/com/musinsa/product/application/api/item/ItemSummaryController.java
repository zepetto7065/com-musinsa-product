package com.musinsa.product.application.api.item;

import com.musinsa.product.application.api.item.payload.ItemConverter;
import com.musinsa.product.application.api.item.payload.ItemMinPricePerCategorySummaryResponse;
import com.musinsa.product.application.api.item.payload.PriceSummaryByCategoryResponse;
import com.musinsa.product.application.api.item.payload.SingleBrandMinSummaryResponse;
import com.musinsa.product.core.service.item.PriceSummary;
import com.musinsa.product.core.service.item.ItemService;
import com.musinsa.product.core.service.item.MinItemSummary;
import com.musinsa.product.core.service.item.SingleBrandMinItemSummary;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemSummaryController {

    private final ItemService itemService;
    @GetMapping("/min-price-summary")
    public ResponseEntity<ItemMinPricePerCategorySummaryResponse> minPriceSummary(){
        MinItemSummary minPricePerCategory = itemService.getMinPricePerCategory();

        ItemMinPricePerCategorySummaryResponse response = ItemConverter.INSTANCE.map(minPricePerCategory);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/single-brand-summary")
    public ResponseEntity<SingleBrandMinSummaryResponse> getSingleBrandMinSummary() {
        SingleBrandMinItemSummary summary = itemService.getSingleBrandMinSummary();

        SingleBrandMinSummaryResponse singleBrandMinSummaryResponse = ItemConverter.INSTANCE.mapTo(summary);

        return ResponseEntity.ok(singleBrandMinSummaryResponse);
    }

    @GetMapping("/price-summary")
    public ResponseEntity<PriceSummaryByCategoryResponse> getPriceSummary(@RequestParam String categoryName){
        PriceSummary summary = itemService.getPriceSummary(categoryName);

        PriceSummaryByCategoryResponse response = ItemConverter.INSTANCE.map(summary);

        return ResponseEntity.ok(response);
    }
}
