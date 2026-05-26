package com.uca.pncsegundoparcialveterinaria.Product.exception.custom;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class ProductNotFoundException extends RuntimeException {
    private final String resource;
    private final String field;
    private final Object rejectedValue;

    public ProductNotFoundException(String resource, String field, Object rejectedValue) {
        this.resource = resource;
        this.field = field;
        this.rejectedValue = rejectedValue;
    }
}