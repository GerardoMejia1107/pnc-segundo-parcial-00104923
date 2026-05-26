package com.uca.pncsegundoparcialveterinaria.Product.services;

import com.uca.pncsegundoparcialveterinaria.Product.custom.ProductMapper;
import com.uca.pncsegundoparcialveterinaria.Product.dto.request.CreateProductDTO;
import com.uca.pncsegundoparcialveterinaria.Product.dto.response.ResponseProductDTO;
import com.uca.pncsegundoparcialveterinaria.Product.model.ProductModel;
import com.uca.pncsegundoparcialveterinaria.Product.repositories.ProductRepositoryJpa;
import com.uca.pncsegundoparcialveterinaria.Product.utils.Category;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductMapper mapper;
    private final ProductRepositoryJpa repositoryJpa;


    @Override
    public ResponseProductDTO create(CreateProductDTO dto) {
        ProductModel newProduct;
        if (repositoryJpa.findByName(dto.getName())) {
            throw new RuntimeException("El producto ya existe en el sistema");
        } else {
            newProduct = repositoryJpa.save(mapper.toProductModel(dto));
        }
        return mapper.toResponseProductDTO(newProduct);
    }

    @Override
    public List<ResponseProductDTO> findAll() {
        return repositoryJpa.findAll()
                .stream()
                .map(mapper::toResponseProductDTO)
                .toList();
    }

    @Override
    public ResponseProductDTO findById(Long id) {
        return repositoryJpa.findById(id)
                .map(mapper::toResponseProductDTO)
                .orElseThrow(
                        () -> new RuntimeException("El producto no existe en el sistema")
                );
    }

    @Override
    public ResponseProductDTO update(Long id, CreateProductDTO dto) {
        ProductModel updateProduct = repositoryJpa.findById(id)
                .orElseThrow(() -> new RuntimeException("El producto no existe en el sistema"));

        updateProduct.setAvailable(dto.getStock() != 0);

        updateProduct.setName(dto.getName());
        updateProduct.setDescription(dto.getDescription());
        updateProduct.setCategory(dto.getCategory());
        updateProduct.setPrice(dto.getPrice());
        updateProduct.setStock(dto.getStock());

        updateProduct.setRequiresPrescription(dto.getRequiresPrescription());
        updateProduct.setExpirationDate(dto.getExpirationDate());
        updateProduct.setSupplier(dto.getSupplier());


        return mapper.toResponseProductDTO(repositoryJpa.save(updateProduct));
    }

    @Override
    public ResponseProductDTO delete(Long id) {
        ProductModel deleteProduct = repositoryJpa.findById(id)
                .orElseThrow(() -> new RuntimeException("El producto no existe en el sistema"));

        if (deleteProduct.getCategory() == Category.VACCINE && deleteProduct.getAvailable() == true) {
            throw new RuntimeException("El producto no se puede eliminar");
        }

        repositoryJpa.delete(deleteProduct);
        return mapper.toResponseProductDTO(deleteProduct);
    }

}
