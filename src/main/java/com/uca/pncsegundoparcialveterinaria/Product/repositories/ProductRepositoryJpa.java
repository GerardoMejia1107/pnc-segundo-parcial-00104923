package com.uca.pncsegundoparcialveterinaria.Product.repositories;

import com.uca.pncsegundoparcialveterinaria.Product.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositoryJpa extends JpaRepository<ProductModel, Long> {
    boolean findByName(String name);
}
