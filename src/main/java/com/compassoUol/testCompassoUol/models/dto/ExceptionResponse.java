package com.compassoUol.testCompassoUol.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {
	
    private Integer status_code;
    
    private StringBuilder message;
}
