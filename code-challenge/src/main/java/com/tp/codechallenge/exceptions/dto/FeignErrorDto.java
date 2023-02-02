package com.tp.codechallenge.exceptions.dto;

import com.tp.codechallenge.client.dto.CommonDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeignErrorDto extends CommonDto {
    private final static long serialVersionUID = 1L;

    private String cod;
    private String message;
}
