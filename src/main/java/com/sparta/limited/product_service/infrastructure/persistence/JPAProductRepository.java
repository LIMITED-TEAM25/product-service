package com.sparta.limited.product_service.infrastructure.persistence;

import com.sparta.limited.product_service.domain.model.Product;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAProductRepository extends JpaRepository<Product, UUID> {

}
