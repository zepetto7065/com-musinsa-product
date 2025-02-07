package com.musinsa.product.application.api.item.payload;

import com.musinsa.product.core.service.item.MinItem;
import com.musinsa.product.core.service.item.MinItemSummary;
import com.musinsa.product.core.service.item.SingleBrandMinItem;
import com.musinsa.product.core.service.item.SingleBrandMinItemSummary;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ItemConverter {
    ItemConverter INSTANCE = Mappers.getMapper(ItemConverter.class);

    ItemMinPricePerCategorySummaryResponse map(MinItemSummary summary);

    ItemMinPricePerCategorySummaryResponse.ItemMinPricePerCategory map(MinItem item);

    SingleBrandMinSummaryResponse mapTo(SingleBrandMinItemSummary summary);

    SingleBrandMinSummaryResponse.MinPriceByCategory mapTo(SingleBrandMinItem item);
}
