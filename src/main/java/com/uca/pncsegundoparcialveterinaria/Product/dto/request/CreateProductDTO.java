package com.uca.pncsegundoparcialveterinaria.Product.dto.request;

import com.uca.pncsegundoparcialveterinaria.Product.utils.Category;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CreateProductDTO {

    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    @NotNull(message = "Category is required")
    private Category category;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    private BigDecimal price;

    @NotNull(message = "Stock value is required")
    @Min(value = 0, message = "Stock must be greater than or equal to 0")
    private Integer stock;

    private Boolean available;

    private Boolean requiresPrescription;

    @NotNull(message = "Expiration date is required")
    @Future(message = "Expiration date must be a future date")
    private LocalDateTime expirationDate;

    @NotBlank(message = "Supplier is required")
    private String supplier;
}

