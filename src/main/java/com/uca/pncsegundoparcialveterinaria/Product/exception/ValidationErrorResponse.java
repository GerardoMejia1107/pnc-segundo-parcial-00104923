package com.uca.pncsegundoparcialveterinaria.Product.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationErrorResponse {
    private Instant timestamp;
    private String message;
    private int status;
    private String error;
    private List<FailedValidation> failedValidationList;

}