package io.github.tainafernandes.productapi.service;

import io.github.tainafernandes.productapi.DTO.Request.ProductRequestDto;
import io.github.tainafernandes.productapi.entity.Product;

public interface ProductService {
    Product save(ProductRequestDto productDTO);
}
