package com.tp.codechallenge.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BackendException extends RuntimeException{
    
    private String status;
    private String message;

}
