package com.sparta.limited.product_service.infrastructure.feign.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(force = true)
public class ClientUpdateResponse {

    private final String result;
    private final String message;


    public ClientUpdateResponse(String result, String message) {
        this.result = result;
        this.message = message;
    }

}
