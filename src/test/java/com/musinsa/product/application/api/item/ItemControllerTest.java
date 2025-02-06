package com.musinsa.product.application.api.item;

import com.musinsa.product.application.api.item.payload.ItemConverter;
import com.musinsa.product.application.api.item.payload.ItemMinPricePerCategorySummaryResponse;
import com.musinsa.product.core.service.ItemService;
import com.musinsa.product.core.service.MinItemSummary;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ItemController.class)
class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService itemService;

    @MockBean
    private ItemConverter itemConverter;

    @Test
    void minPriceSummary_ShouldReturnMinPriceSummaryResponse() throws Exception {
        MinItemSummary mockSummary = MinItemSummary.builder()
                .totalPrice(BigDecimal.valueOf(2000L))
                .build();

        when(itemService.getMinPricePerCategory()).thenReturn(mockSummary);

        mockMvc.perform(get("/items/min-price-summary")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.totalPrice").value(2000))
                .andDo(print());
    }
}