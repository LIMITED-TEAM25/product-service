package com.sparta.limited.product_service.application.dto.request;

import java.math.BigDecimal;
import lombok.Getter;

@Getter
public class ProductUpdateRequest {

    private String description;
    private BigDecimal price;

}
