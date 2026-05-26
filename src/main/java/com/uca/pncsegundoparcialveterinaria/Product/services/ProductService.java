package com.uca.pncsegundoparcialveterinaria.Product.services;

import com.uca.pncsegundoparcialveterinaria.Product.dto.request.CreateProductDTO;
import com.uca.pncsegundoparcialveterinaria.Product.dto.response.ResponseProductDTO;

import java.util.List;

public interface ProductService {
    ResponseProductDTO create(CreateProductDTO dto);

    List<ResponseProductDTO> findAll();

    ResponseProductDTO findById(Long id);

    ResponseProductDTO update(Long id, CreateProductDTO dto);

    ResponseProductDTO delete(Long id);
}
