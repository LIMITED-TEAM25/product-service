package com.sparta.limited.product_service.application.dto.response;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.Getter;

@Getter
public class ProductCreateResponse {

    private final UUID id;
    private final String title;
    private final String description;
    private final BigDecimal price;

    private ProductCreateResponse(UUID id, String title, String description, BigDecimal price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public static ProductCreateResponse of(UUID id, String title, String description,
        BigDecimal price) {
        return new ProductCreateResponse(id, title, description, price);
    }

}
