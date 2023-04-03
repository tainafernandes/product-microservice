package io.github.tainafernandes.productapi.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTOResponse {

    private UUID id;
    private String name;
    private String category;
    private Double price;
}
