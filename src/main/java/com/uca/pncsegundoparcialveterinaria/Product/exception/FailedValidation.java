package com.uca.pncsegundoparcialveterinaria.Product.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FailedValidation {
    private String field;
    private String message;
    private Object rejectedValue;
}