package com.uca.pncsegundoparcialveterinaria.Product.custom;

import com.uca.pncsegundoparcialveterinaria.Product.dto.request.CreateProductDTO;
import com.uca.pncsegundoparcialveterinaria.Product.dto.response.ResponseProductDTO;
import com.uca.pncsegundoparcialveterinaria.Product.model.ProductModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data

public class ProductMapper {
    public ProductModel toProductModel(CreateProductDTO dto) {
        ProductModel productModel = new ProductModel();
        productModel.setName(dto.getName());
        productModel.setDescription(dto.getDescription());
        productModel.setCategory(dto.getCategory());
        productModel.setPrice(dto.getPrice());
        productModel.setStock(dto.getStock());
        productModel.setAvailable(dto.getAvailable());
        productModel.setRequiresPrescription(dto.getRequiresPrescription());
        productModel.setExpirationDate(dto.getExpirationDate());
        productModel.setSupplier(dto.getSupplier());
        return productModel;
    }

    public ResponseProductDTO toResponseProductDTO(ProductModel productModel) {
        return new ResponseProductDTO(
                productModel.getName(),
                productModel.getDescription(),
                productModel.getCategory(),
                productModel.getPrice(),
                productModel.getStock(),
                productModel.getAvailable(),
                productModel.getRequiresPrescription(),
                productModel.getExpirationDate(),
                productModel.getSupplier()
        );
    }
}
