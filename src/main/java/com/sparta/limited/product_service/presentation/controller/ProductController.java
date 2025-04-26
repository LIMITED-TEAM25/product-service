package com.sparta.limited.product_service.presentation.controller;

import com.sparta.limited.common_module.common.annotation.CurrentUserId;
import com.sparta.limited.common_module.common.aop.RoleCheck;
import com.sparta.limited.product_service.application.dto.request.ProductCreateRequest;
import com.sparta.limited.product_service.application.dto.request.ProductUpdateRequest;
import com.sparta.limited.product_service.application.dto.response.ProductCreateResponse;
import com.sparta.limited.product_service.application.dto.response.ProductReadResponse;
import com.sparta.limited.product_service.application.dto.response.ProductUpdateResponse;
import com.sparta.limited.product_service.application.service.ProductService;
import java.net.URI;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @RoleCheck("ROLE_ADMIN")
    @PostMapping
    public ResponseEntity<ProductCreateResponse> createProduct(
        @RequestBody ProductCreateRequest request,
        @CurrentUserId Long userId) {
        ProductCreateResponse response = productService.createProduct(request);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(response.getId())
            .toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductReadResponse> getProduct(@PathVariable UUID productId) {
        ProductReadResponse response = productService.getProduct(productId);
        return ResponseEntity.ok(response);
    }

    @RoleCheck("ROLE_ADMIN")
    @PutMapping("/{productId}")
    public ResponseEntity<ProductUpdateResponse> updateProduct(
        @PathVariable UUID productId,
        @RequestBody ProductUpdateRequest request,
        @CurrentUserId Long userId) {

        ProductUpdateResponse response = productService.updateProduct(productId, request);
        return ResponseEntity.ok(response);
    }

}
