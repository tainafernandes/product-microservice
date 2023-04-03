package io.github.tainafernandes.productapi.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTORequest {

    private UUID id;
    
    @NotBlank(message = "Name is a required field")
    private String name;

    @NotBlank(message = "Category is a required field")
    private String category;

    @NotNull(message = "Price cannot be null")
    private Double price;
}
