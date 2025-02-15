package com.musinsa.product.application.api.item;

import com.musinsa.product.application.api.item.payload.ItemConverter;
import com.musinsa.product.core.service.item.ItemSummaryService;
import com.musinsa.product.core.service.item.summary.MinItemSummary;
import com.musinsa.product.core.service.item.summary.PriceSummary;
import com.musinsa.product.core.service.item.summary.SingleBrandMinItemSummary;
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

@WebMvcTest(ItemSummaryController.class)
class ItemSummaryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemSummaryService itemSummaryService;

    @MockBean
    private ItemConverter itemConverter;

    @Test
    void minPriceSummary_ShouldReturnMinPriceSummaryResponse() throws Exception {
        MinItemSummary mockSummary = MinItemSummary.builder()
                .totalPrice(BigDecimal.valueOf(2000L))
                .build();

        when(itemSummaryService.getMinPricePerCategory()).thenReturn(mockSummary);

        mockMvc.perform(get("/item-summary/min-price")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.totalPrice").value(2000))
                .andDo(print());
    }

    @Test
    void getSingleBrandMinSummary() throws Exception {
        SingleBrandMinItemSummary summary = SingleBrandMinItemSummary.builder()
                .totalPrice(BigDecimal.valueOf(2000L))
                .brandName("D")
                .build();

        when(itemSummaryService.getSingleBrandMinSummary()).thenReturn(summary);

        mockMvc.perform(get("/item-summary/single-brand")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.brandName").value("D"))
                .andExpect(jsonPath("$.totalPrice").value(2000L))
                .andDo(print());
    }

    @Test
    void getPriceSummary() throws Exception {
        String categoryName = "상의";
        PriceSummary summary = PriceSummary.builder()
                .categoryName(categoryName)
                .build();

        when(itemSummaryService.getPriceSummary(categoryName)).thenReturn(summary);

        mockMvc.perform(get("/item-summary/price")
                        .param("categoryName", "상의")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.categoryName").value(categoryName))
                .andDo(print());
    }
}