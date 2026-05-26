package com.uca.pncsegundoparcialveterinaria.Product.dto.response;

import com.uca.pncsegundoparcialveterinaria.Product.utils.Category;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ResponseProductDTO {
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
