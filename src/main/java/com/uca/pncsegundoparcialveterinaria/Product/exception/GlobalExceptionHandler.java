package com.uca.pncsegundoparcialveterinaria.Product.exception;


import com.uca.pncsegundoparcialveterinaria.Product.exception.custom.ProductAlreadyExistsException;
import com.uca.pncsegundoparcialveterinaria.Product.exception.custom.ProductNotFoundException;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.List;


@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex) {
        List<FailedValidation> validationList = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> new FailedValidation(
                        fieldError.getField(),
                        fieldError.getDefaultMessage(),
                        fieldError.getRejectedValue()
                ))
                .toList();

        ValidationErrorResponse response = ValidationErrorResponse.builder()
                .timestamp(Instant.now())
                .message("One or more fields have validation errors")
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Validation failed")
                .failedValidationList(validationList)
                .build();

        log.warn("validation failed: {}", validationList);

        return ResponseEntity.badRequest()
                .body(response);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ValidationErrorResponse> handleConstraintViolationException(ConstraintViolationException ex) {
        List<FailedValidation> validationList = ex.getConstraintViolations()
                .stream()
                .map(constraintViolation -> new FailedValidation(
                        constraintViolation.getPropertyPath()
                                .toString(),
                        constraintViolation.getMessage(),
                        constraintViolation.getInvalidValue()
                ))
                .toList();

        ValidationErrorResponse response = ValidationErrorResponse.builder()
                .timestamp(Instant.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .message("One or more constraints were violated")
                .error("Constraint violation")
                .failedValidationList(validationList)
                .build();

        return ResponseEntity.badRequest()
                .body(response);
    }


    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ValidationErrorResponse> handlePirateNotFoundException(ProductNotFoundException ex) {
        List<FailedValidation> validationList = List.of(new FailedValidation(
                ex.getField(), ex.getMessage(), ex.getRejectedValue()
        ));

        ValidationErrorResponse response = ValidationErrorResponse.builder()
                .timestamp(Instant.now())
                .message("Pirate was not found in storage")
                .error("Pirate with specified id was not found")
                .status(HttpStatus.NOT_FOUND.value())
                .failedValidationList(validationList)
                .build();

        return ResponseEntity.badRequest()
                .body(response);

    }

    @ExceptionHandler(ProductAlreadyExistsException.class)
    public ResponseEntity<ValidationErrorResponse> handleNicknameAlreadyExistsException(
            ProductAlreadyExistsException ex) {
        List<FailedValidation> validationList = List.of(new FailedValidation(
                ex.getField(), ex.getMessage(), ex.getRejectedValue()
        ));

        ValidationErrorResponse response = ValidationErrorResponse.builder()
                .timestamp(Instant.now())
                .status(HttpStatus.FORBIDDEN.value())
                .message("Pirate nickname already exists")
                .error("Pirate nickname cannot be reused by another pirate")
                .failedValidationList(validationList)
                .build();

        return ResponseEntity.badRequest()
                .body(response);
    }
}