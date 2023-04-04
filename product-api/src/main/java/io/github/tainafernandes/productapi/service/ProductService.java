package io.github.tainafernandes.productapi.service;

import io.github.tainafernandes.productapi.DTO.Request.ProductRequestDto;
import io.github.tainafernandes.productapi.DTO.Response.ProductResponseDto;
import io.github.tainafernandes.productapi.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    Product save(ProductRequestDto productDto);
    Optional<Product> getById(UUID id);

    List<Product> findAll();
}
