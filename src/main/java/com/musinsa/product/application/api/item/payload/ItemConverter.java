package com.musinsa.product.application.api.item.payload;

import com.musinsa.product.core.service.MinItem;
import com.musinsa.product.core.service.MinItemSummary;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ItemConverter {
    ItemConverter INSTANCE = Mappers.getMapper(ItemConverter.class);

    ItemMinPricePerCategorySummaryResponse map(MinItemSummary summaryVo);

    ItemMinPricePerCategorySummaryResponse.ItemMinPricePerCategory map(MinItem detailVo);
}
