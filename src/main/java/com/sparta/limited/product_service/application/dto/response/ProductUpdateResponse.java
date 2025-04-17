package com.sparta.limited.product_service.application.dto.response;

import com.sparta.limited.product_service.application.service.ProductClientUpdateInfo;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Getter;

@Getter
public class ProductUpdateResponse {

    private final UUID id;
    private final String description;
    private final BigDecimal price;
    private final ProductClientUpdateInfo limitedProductResultMessage;
    private final ProductClientUpdateInfo auctionProductResultMessage;
    private final ProductClientUpdateInfo preuserProductResultMessage;

    private ProductUpdateResponse(UUID id, String description, BigDecimal price,
        ProductClientUpdateInfo limitedProductResultMessage,
        ProductClientUpdateInfo auctionProductResultMessage,
        ProductClientUpdateInfo preuserProductResultMessage) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.limitedProductResultMessage = limitedProductResultMessage;
        this.auctionProductResultMessage = auctionProductResultMessage;
        this.preuserProductResultMessage = preuserProductResultMessage;
    }

    public static ProductUpdateResponse of(UUID id, String description, BigDecimal price,
        ProductClientUpdateInfo limitedProductResultMessage,
        ProductClientUpdateInfo auctionProductResultMessage,
        ProductClientUpdateInfo preuserProductResultMessage) {
        return new ProductUpdateResponse(id, description, price, limitedProductResultMessage,
            auctionProductResultMessage, preuserProductResultMessage);
    }

}
