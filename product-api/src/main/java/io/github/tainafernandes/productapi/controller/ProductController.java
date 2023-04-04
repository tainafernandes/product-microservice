package io.github.tainafernandes.productapi.controller;

import io.github.tainafernandes.productapi.DTO.Request.ProductRequestDto;
import io.github.tainafernandes.productapi.DTO.Response.ProductResponseDto;
import io.github.tainafernandes.productapi.entity.Product;
import io.github.tainafernandes.productapi.service.Impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductServiceImpl service;
    private final ModelMapper mapper;

    @PostMapping
    @ResponseStatus(CREATED)
    public ProductResponseDto create(@RequestBody @Valid ProductRequestDto dto){
        return mapper.map(service.create(dto), ProductResponseDto.class);
    }
    @GetMapping("{id}")
    @ResponseStatus(OK)
    public ProductRequestDto getById(@PathVariable UUID id){
        return service.getById(id)
                .map(product -> mapper.map(product, ProductRequestDto.class))
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
    }
    @GetMapping
    @ResponseStatus(OK)
    public List<Product> findAll(){
        return service.findAll();
    }

    @PutMapping("{id}")
    @ResponseStatus(OK)
    public ProductResponseDto update (@PathVariable UUID id, @RequestBody @Valid ProductRequestDto dto){
        return service.update(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable UUID id){
        service.deleteById(id);
    }
}
