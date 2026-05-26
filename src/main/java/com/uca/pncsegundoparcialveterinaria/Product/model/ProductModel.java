package com.uca.pncsegundoparcialveterinaria.Product.model;

import com.uca.pncsegundoparcialveterinaria.Product.utils.Category;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Data
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Category category;
    private BigDecimal price;
    private Integer stock;
    private Boolean available;
    private Boolean requiresPrescription;
    private LocalDateTime expirationDate;
    private String supplier;
}
