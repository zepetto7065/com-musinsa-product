package com.musinsa.product.core.service.brand;

import com.musinsa.product.application.persistence.brand.BrandRepository;
import com.musinsa.product.core.domain.Brand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;
    @Transactional
    public void create(String command) {
        Brand newBrand = Brand.builder()
                .name(command)
                .build();
        brandRepository.save(newBrand);
    }

    @Transactional
    public Brand update(Brand command){
        Brand brand = brandRepository.findById(command.getId());
        brand.setName(command.getName());
        return brandRepository.save(brand);
    }

    @Transactional
    public void delete(Long id) {
        brandRepository.deleteById(id);
    }
}
