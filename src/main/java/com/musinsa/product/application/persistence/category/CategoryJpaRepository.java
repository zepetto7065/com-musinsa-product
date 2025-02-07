package com.musinsa.product.application.persistence.category;

import com.musinsa.product.core.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaRepository extends JpaRepository<Category, Long> {
}
