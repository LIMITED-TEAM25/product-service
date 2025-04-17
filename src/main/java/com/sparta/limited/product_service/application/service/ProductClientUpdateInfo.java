package com.sparta.limited.product_service.application.service;

import lombok.Getter;

@Getter
public class ProductClientUpdateInfo {

    private final String result;
    private final String message;

    public ProductClientUpdateInfo(String result, String message) {
        this.result = result;
        this.message = message;
    }

}
