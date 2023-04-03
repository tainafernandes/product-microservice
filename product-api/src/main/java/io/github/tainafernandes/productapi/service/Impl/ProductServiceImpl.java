package io.github.tainafernandes.productapi.service.Impl;

import io.github.tainafernandes.productapi.DTO.Request.ProductRequestDto;
import io.github.tainafernandes.productapi.entity.Product;
import io.github.tainafernandes.productapi.repository.ProductRepository;
import io.github.tainafernandes.productapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    private final ModelMapper mapper;

    @Override
    public Product save(ProductRequestDto productDTO) {
        //fazer validações - TRATAMENTO DE ERRO
        //Produto já existe? Se sim retorna erro ao tentar salvar
        return repository.save(mapper.map (productDTO, Product.class));
    }
}
