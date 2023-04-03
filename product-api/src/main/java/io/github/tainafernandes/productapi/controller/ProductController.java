package io.github.tainafernandes.productapi.controller;

import io.github.tainafernandes.productapi.DTO.Request.ProductRequestDto;
import io.github.tainafernandes.productapi.DTO.Response.ProductResponseDto;
import io.github.tainafernandes.productapi.service.Impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductServiceImpl service;
    private final ModelMapper mapper;

    @PostMapping
    @ResponseStatus(CREATED)
    public ProductResponseDto create(@RequestBody ProductRequestDto dto){
        return mapper.map(service.save(dto), ProductResponseDto.class);
    }
}
