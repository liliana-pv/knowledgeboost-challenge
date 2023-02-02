package com.tp.codechallenge.exceptions.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConstraintErrorDto {
    
    private String description;
    private String field;
}
