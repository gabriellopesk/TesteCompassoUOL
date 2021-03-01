package com.compassoUol.testCompassoUol.models.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	
	@NotBlank
    private String name;
    
	@NotBlank
    private String description;
    
	@PositiveOrZero
    private BigDecimal price;
}
