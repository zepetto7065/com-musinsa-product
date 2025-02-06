package com.musinsa.product.core.service;

import com.jayway.jsonpath.internal.function.numeric.Min;
import com.musinsa.product.application.persistence.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ItemServiceTest {
    @InjectMocks
    private ItemService itemService;
    @Mock
    private ItemRepository itemRepository;

    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void summation_test(){
        //Given
        MinItem item1 = MinItem.builder()
                .price(BigDecimal.valueOf(2000L))
                .categoryName("상의")
                .brandName("A")
                .build();
        MinItem item2 = MinItem.builder()
                .price(BigDecimal.valueOf(10000L))
                .categoryName("하의")
                .brandName("C")
                .build();
        List<MinItem> minItemList = new ArrayList<>(Arrays.asList(item1, item2));
        when(itemRepository.findMinPricedProductPerCategory()).thenReturn(minItemList);

        //When
        MinItemSummary minPricePerCategory = itemService.getMinPricePerCategory();

        //Then
        assertEquals(minPricePerCategory.getTotalPrice(), BigDecimal.valueOf(12000L));
        assertEquals(minPricePerCategory.getDetailList().size(), 2);
    }
}