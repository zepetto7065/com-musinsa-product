package com.musinsa.product.application.api.item;

import com.musinsa.product.application.api.item.payload.ItemConverter;
import com.musinsa.product.application.api.item.payload.ItemSaveResponse;
import com.musinsa.product.application.api.item.payload.SaveItemRequest;
import com.musinsa.product.core.domain.Item;
import com.musinsa.product.core.service.item.ItemService;
import com.musinsa.product.core.service.item.ItemVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody SaveItemRequest request){
        itemService.create(ItemVo.builder()
                        .name(request.getName())
                        .price(request.getPrice())
                        .brandId(request.getBrandId())
                        .categoryId(request.getCategoryId())
                .build());
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<ItemSaveResponse> update(@RequestBody SaveItemRequest request){
        Item update = itemService.update(ItemVo.builder()
                        .itemId(request.getItemId())
                        .name(request.getName())
                        .price(request.getPrice())
                        .brandId(request.getBrandId())
                        .categoryId(request.getCategoryId())
                .build());
        return ResponseEntity.ok(ItemConverter.INSTANCE.map(update));
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> delete(@PathVariable Long itemId){
        itemService.delete(itemId);
        return ResponseEntity.ok().build();
    }

}
