package com.sparta.limited.product_service.application.dto.response;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ProductCreateResponse {

    private final UUID id;
    private final String title;
    private final String description;
    private final BigDecimal price;

}
