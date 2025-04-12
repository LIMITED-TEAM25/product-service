package com.sparta.limited.product_service.infrastructure.repository;

import com.sparta.limited.product_service.domain.model.Product;
import com.sparta.limited.product_service.domain.repository.ProductRepository;
import com.sparta.limited.product_service.infrastructure.persistence.JpaProductRepository;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final JpaProductRepository jpaProductRepository;

    @Override
    public void save(Product product) {
        jpaProductRepository.save(product);
    }

    @Override
    public Optional<Product> findById(UUID productId) {
        return jpaProductRepository.findById(productId);
    }

}
