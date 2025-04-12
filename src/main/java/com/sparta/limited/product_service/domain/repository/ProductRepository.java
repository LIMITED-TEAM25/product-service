package com.sparta.limited.product_service.domain.repository;

import com.sparta.limited.product_service.domain.model.Product;
import java.util.UUID;

public interface ProductRepository {

    void save(Product product);

    Product findById(UUID productId);

    Product findByIdAndDeletedAtIsNull(UUID productId);
}
