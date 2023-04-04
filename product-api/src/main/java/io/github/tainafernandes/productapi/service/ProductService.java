package io.github.tainafernandes.productapi.service;

import io.github.tainafernandes.productapi.DTO.Request.ProductRequestDto;
import io.github.tainafernandes.productapi.DTO.Response.ProductResponseDto;
import io.github.tainafernandes.productapi.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    ProductResponseDto create(ProductRequestDto productDto);
    Optional<Product> getById(UUID id);
    List<Product> findAll();
    ProductResponseDto update(UUID id, ProductRequestDto dto);
    void deleteById(UUID id);
}
