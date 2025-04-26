package com.sparta.limited.product_service.application.dto.request;

import java.math.BigDecimal;
import lombok.Getter;

@Getter
public class ProductCreateRequest {

    private String title;
    private String description;
    private BigDecimal price;

}
