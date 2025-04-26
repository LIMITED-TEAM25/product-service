package com.sparta.limited.product_service.application.mapper;

import com.sparta.limited.product_service.application.dto.request.ProductCreateRequest;
import com.sparta.limited.product_service.application.dto.response.ProductCreateResponse;
import com.sparta.limited.product_service.application.dto.response.ProductReadResponse;
import com.sparta.limited.product_service.application.dto.response.ProductUpdateResponse;
import com.sparta.limited.product_service.application.service.ProductClientUpdateInfo;
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

    public static ProductUpdateResponse toUpdateResponse(Product product,
        ProductClientUpdateInfo limitedProductResultMessage,
        ProductClientUpdateInfo auctionProductResultMessage,
        ProductClientUpdateInfo preuserProductResultMessage) {
        return ProductUpdateResponse.of(product.getId(), product.getDescription(),
            product.getPrice(), limitedProductResultMessage, auctionProductResultMessage,
            preuserProductResultMessage);
    }

}