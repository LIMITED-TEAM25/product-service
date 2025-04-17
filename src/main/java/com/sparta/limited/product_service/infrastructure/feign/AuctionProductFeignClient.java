package com.sparta.limited.product_service.infrastructure.feign;

import com.sparta.limited.product_service.application.dto.request.ProductUpdateRequest;
import com.sparta.limited.product_service.infrastructure.feign.dto.ClientUpdateResponse;
import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "auction-service")
public interface AuctionProductFeignClient {

    @PutMapping("/api/v1/internal/auction-products/{productId}/update-product-info/")
    ClientUpdateResponse updateProduct(
        @PathVariable UUID productId,
        @RequestBody ProductUpdateRequest request);

}
