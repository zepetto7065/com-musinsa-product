package com.musinsa.product.application.api.brand;

import com.musinsa.product.application.api.brand.payload.BrandConverter;
import com.musinsa.product.application.api.brand.payload.BrandSaveResponse;
import com.musinsa.product.application.api.brand.payload.SaveBrandRequest;
import com.musinsa.product.core.domain.Brand;
import com.musinsa.product.core.service.brand.BrandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/brands")
@RequiredArgsConstructor
public class BrandController {
    private final BrandService brandService;

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody SaveBrandRequest command){
        brandService.create(command.getName());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{brandId}")
    public ResponseEntity<BrandSaveResponse> update(@PathVariable Long brandId, @RequestBody SaveBrandRequest request){
        Brand command = Brand.builder()
                .id(brandId)
                .name(request.getName())
                .build();
        Brand update = brandService.update(command);
        return ResponseEntity.ok(BrandConverter.INSTANCE.map(update));
    }

    @DeleteMapping("/{brandId}")
    public ResponseEntity<Void> delete(@PathVariable Long brandId){
        brandService.delete(brandId);
        return ResponseEntity.ok().build();
    }

}
