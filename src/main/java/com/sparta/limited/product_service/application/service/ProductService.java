package com.sparta.limited.product_service.application.service;

import com.sparta.limited.product_service.application.dto.request.ProductCreateRequest;
import com.sparta.limited.product_service.application.dto.request.ProductUpdateRequest;
import com.sparta.limited.product_service.application.dto.response.ProductCreateResponse;
import com.sparta.limited.product_service.application.dto.response.ProductReadResponse;
import com.sparta.limited.product_service.application.dto.response.ProductUpdateResponse;
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
    private final ProductUpdateClientService productUpdateClientService;

    @Transactional
    public ProductCreateResponse createProduct(ProductCreateRequest request) {
        Product product = ProductMapper.toCreateEntity(request);

        productRepository.save(product);
        return ProductMapper.toCreateResponse(product);
    }

    @Transactional(readOnly = true)
    public ProductReadResponse getProduct(UUID productId) {
        Product product = productRepository.findById(productId);

        return ProductMapper.toReadResponse(product);
    }

    @Transactional
    public ProductUpdateResponse updateProduct(UUID productId, ProductUpdateRequest request) {
        Product product = productRepository.findById(productId);
        product.update(request.getDescription(), request.getPrice());

        ProductClientUpdateInfo limitedProductResultMessage = productUpdateClientService.updateLimitedProduct(
            productId, request);
        ProductClientUpdateInfo auctionProductResultMessage = productUpdateClientService.updateAuctionProduct(
            productId, request);
        ProductClientUpdateInfo preuserProductResultMessage = productUpdateClientService.updatePreuserProduct(
            productId, request);

        return ProductMapper.toUpdateResponse(product, limitedProductResultMessage,
            auctionProductResultMessage, preuserProductResultMessage);
    }
}
