package com.sparta.limited.product_service.application.service;

import com.sparta.limited.product_service.application.dto.request.ProductCreateRequest;
import com.sparta.limited.product_service.application.dto.response.ProductCreateResponse;
import com.sparta.limited.product_service.application.dto.response.ProductReadResponse;
import com.sparta.limited.product_service.application.mapper.ProductMapper;
import com.sparta.limited.product_service.domain.model.Product;
import com.sparta.limited.product_service.domain.repository.ProductRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j(topic = "ProductService")
public class ProductService {

    private final ProductRepository productRepository;

    // 상품 생성
    @Transactional
    public ProductCreateResponse createProduct(ProductCreateRequest request) {
        Product product = ProductMapper.toCreateEntity(request);

        productRepository.save(product);
        return ProductMapper.toCreateResponse(product);
    }

    // 상품 단건 조회
    @Transactional(readOnly = true)
    public ProductReadResponse getProduct(UUID productId) {
        Product product = productRepository.findById(productId);

        return ProductMapper.toReadResponse(product);
    }
}
