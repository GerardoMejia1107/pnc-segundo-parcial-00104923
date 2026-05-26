package com.uca.pncsegundoparcialveterinaria.Product.exception.custom;

import lombok.Getter;

@Getter
public class ProductAlreadyExistsException extends RuntimeException {
    private final String resource;
    private final String field;
    private final Object rejectedValue;

    public ProductAlreadyExistsException(String resource, String field, Object rejectedValue) {
        this.resource = resource;
        this.field = field;
        this.rejectedValue = rejectedValue;
    }
}
