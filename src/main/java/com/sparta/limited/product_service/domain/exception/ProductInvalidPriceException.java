package com.sparta.limited.product_service.domain.exception;

import com.sparta.limited.common_module.exception.BusinessException;
import com.sparta.limited.common_module.exception.ErrorCode;

public class ProductInvalidPriceException extends BusinessException {

    public ProductInvalidPriceException() {
        super(ErrorCode.INVALID_PARAMETER, "잘못된 상품 가격입니다.");
    }
}
