package com.sparta.limited.product_service.application.mapper;

import com.sparta.limited.product_service.application.dto.request.ProductCreateRequest;
import com.sparta.limited.product_service.application.dto.response.ProductCreateResponse;
import com.sparta.limited.product_service.domain.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toEntity(ProductCreateRequest request) {
        return Product.of(request.getTitle(), request.getDescription(), request.getPrice());
    }

    public ProductCreateResponse toResponse(Product product) {
        return new ProductCreateResponse(product.getId(), product.getTitle(),
            product.getDescription(), product.getPrice());
    }

}
