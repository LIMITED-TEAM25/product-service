package com.sparta.limited.product_service.infrastructure.repository;

import com.sparta.limited.product_service.domain.model.Product;
import com.sparta.limited.product_service.domain.repository.ProductRepository;
import com.sparta.limited.product_service.infrastructure.persistence.JPAProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final JPAProductRepository jpaProductRepository;

    @Override
    public void save(Product product) {
        jpaProductRepository.save(product);
    }

}
