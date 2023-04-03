package io.github.tainafernandes.productapi.service.Impl;

import io.github.tainafernandes.productapi.repository.ProductRepository;
import io.github.tainafernandes.productapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends ProductService {
    private final ProductRepository repository;
    private final ModelMapper mapper;

}
