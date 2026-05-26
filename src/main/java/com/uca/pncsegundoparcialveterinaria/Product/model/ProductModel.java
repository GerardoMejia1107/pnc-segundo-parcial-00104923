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
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Category category;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "available")
    private Boolean available;
    @Column(name = "requires_prescription")
    private Boolean requiresPrescription;
    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;
    @Column(name = "supplier")
    private String supplier;
}
