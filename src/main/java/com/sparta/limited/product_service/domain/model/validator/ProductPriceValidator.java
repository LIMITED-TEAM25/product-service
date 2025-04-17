package com.sparta.limited.product_service.domain.model.validator;

import com.sparta.limited.product_service.domain.exception.ProductInvalidPriceException;
import java.math.BigDecimal;

public class ProductPriceValidator {

    public static void validatePrice(BigDecimal price) {
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ProductInvalidPriceException();
        }
    }

}
