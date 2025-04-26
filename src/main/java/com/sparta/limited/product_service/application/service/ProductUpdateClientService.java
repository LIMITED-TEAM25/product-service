package com.sparta.limited.product_service.application.service;

import com.sparta.limited.product_service.application.dto.request.ProductUpdateRequest;
import com.sparta.limited.product_service.infrastructure.feign.AuctionProductFeignClient;
import com.sparta.limited.product_service.infrastructure.feign.LimitedProductFeignClient;
import com.sparta.limited.product_service.infrastructure.feign.PreuserProductFeignClient;
import com.sparta.limited.product_service.infrastructure.feign.dto.ClientUpdateResponse;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductUpdateClientService {

    private final LimitedProductFeignClient limitedProductFeignClient;
    private final AuctionProductFeignClient auctionProductFeignClient;
    private final PreuserProductFeignClient preuserProductFeignClient;

    public ProductClientUpdateInfo updateLimitedProduct(UUID productId,
        ProductUpdateRequest request) {
        ClientUpdateResponse response = limitedProductFeignClient.updateProduct(productId, request);
        return new ProductClientUpdateInfo(response.getResult(), response.getMessage());
    }

    public ProductClientUpdateInfo updateAuctionProduct(UUID productId,
        ProductUpdateRequest request) {
        ClientUpdateResponse response = auctionProductFeignClient.updateProduct(productId, request);
        return new ProductClientUpdateInfo(response.getResult(), response.getMessage());
    }

    public ProductClientUpdateInfo updatePreuserProduct(UUID productId,
        ProductUpdateRequest request) {
        ClientUpdateResponse response = preuserProductFeignClient.updateProduct(productId, request);
        return new ProductClientUpdateInfo(response.getResult(), response.getMessage());
    }

}
