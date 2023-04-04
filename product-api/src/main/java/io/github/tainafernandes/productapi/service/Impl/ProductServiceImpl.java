package io.github.tainafernandes.productapi.service.Impl;

import io.github.tainafernandes.productapi.DTO.Request.ProductRequestDto;
import io.github.tainafernandes.productapi.DTO.Response.ProductResponseDto;
import io.github.tainafernandes.productapi.entity.Product;
import io.github.tainafernandes.productapi.repository.ProductRepository;
import io.github.tainafernandes.productapi.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    private final ModelMapper mapper;

    @Override
    @Transactional
    public ProductResponseDto create(ProductRequestDto productDto) {
        //fazer validações - TRATAMENTO DE ERRO
        //Produto já existe? Se sim retorna erro ao tentar salvar
        Product product = repository.save(mapper.map(productDto, Product.class));
        return mapper.map(product, ProductResponseDto.class);
    }
    @Override
    public Optional<Product> getById(UUID id) {
        return repository.findById(id);
    }
    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public ProductResponseDto update(UUID id, ProductRequestDto dto) {
        Product product = new Product();

        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setCategory(dto.getCategory());

        mapper.map(getById(id), Product.class);

        repository.save(product);

        return mapper.map(product, ProductResponseDto.class);
    }
    @Override
    public void deleteById(UUID id) {
        Product product = mapper.map(getById(id), Product.class);
        repository.deleteById(product.getId());
    }


}
