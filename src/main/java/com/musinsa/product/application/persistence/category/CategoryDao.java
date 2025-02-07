package com.musinsa.product.application.persistence.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryDao implements CategoryRepository {
    private final CategoryJpaRepository categoryJpaRepository;
    @Override
    public long count() {
        return categoryJpaRepository.count();
    }
}
