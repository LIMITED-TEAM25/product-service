package com.sparta.limited.product_service.application.mapper;

import com.sparta.limited.product_service.application.dto.request.ProductCreateRequest;
import com.sparta.limited.product_service.application.dto.response.ProductCreateResponse;
import com.sparta.limited.product_service.application.dto.response.ProductReadResponse;
import com.sparta.limited.product_service.domain.model.Product;

public class ProductMapper {

    public static Product toCreateEntity(ProductCreateRequest request) {
        return Product.of(request.getTitle(), request.getDescription(), request.getPrice());
    }

    public static ProductCreateResponse toCreateResponse(Product product) {
        return ProductCreateResponse.of(product.getId(), product.getTitle(),
            product.getDescription(), product.getPrice());
    }

    public static ProductReadResponse toReadResponse(Product product) {
        return ProductReadResponse.of(product.getId(), product.getTitle(),
            product.getDescription(), product.getPrice());
    }

}