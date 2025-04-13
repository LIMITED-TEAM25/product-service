package com.sparta.limited.product_service.presentation.controller;

import com.sparta.limited.product_service.application.dto.response.ProductReadResponse;
import com.sparta.limited.product_service.application.service.ProductService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/internal/products")
@RequiredArgsConstructor
public class ProductInternalController {

    private final ProductService productService;

    @GetMapping("/{productId}")
    public ResponseEntity<ProductReadResponse> getProduct(@PathVariable UUID productId) {
        ProductReadResponse response = productService.getProduct(productId);
        return ResponseEntity.ok(response);
    }

}
