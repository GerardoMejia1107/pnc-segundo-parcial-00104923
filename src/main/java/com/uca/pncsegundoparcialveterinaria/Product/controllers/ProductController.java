package com.uca.pncsegundoparcialveterinaria.Product.controllers;

import com.uca.pncsegundoparcialveterinaria.Product.dto.request.CreateProductDTO;
import com.uca.pncsegundoparcialveterinaria.Product.dto.response.ResponseProductDTO;
import com.uca.pncsegundoparcialveterinaria.Product.model.ProductModel;
import com.uca.pncsegundoparcialveterinaria.Product.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<ResponseProductDTO> addProduct(@Valid @RequestBody CreateProductDTO newProduct) {
        ResponseProductDTO response = productService.create(newProduct);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ResponseProductDTO>> getAllProducts() {
        List<ResponseProductDTO> response = productService.findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<List<ResponseProductDTO>> getById(@PathVariable Long id) {
        List<ResponseProductDTO> response = productService.findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<ResponseProductDTO> deleteProduct(@PathVariable Long id) {
        ResponseProductDTO response = productService.delete(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ResponseProductDTO> updateProduct(@PathVariable Long id,
                                                            @Valid @RequestBody CreateProductDTO newProduct) {
        ResponseProductDTO response = productService.update(id, newProduct);
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }
}
