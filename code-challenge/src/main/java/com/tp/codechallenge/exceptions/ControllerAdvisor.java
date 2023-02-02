package com.tp.codechallenge.exceptions;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.tp.codechallenge.exceptions.dto.ConstraintErrorDto;

@ControllerAdvice
public class ControllerAdvisor {
    
    @ExceptionHandler(value = { ConstraintViolationException.class })
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        List<ConstraintErrorDto> errorResponseList = new ArrayList<>();
        for (ConstraintViolation<?> violation : violations) {
            ConstraintErrorDto errorResponse = new ConstraintErrorDto();
            errorResponse.setDescription(violation.getMessage());
            errorResponse.setField(violation.getPropertyPath().toString());
            errorResponseList.add(errorResponse);
        }
        return new ResponseEntity<>(errorResponseList, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BackendException.class)
    @ResponseBody
    public ResponseEntity<Object> handle(BackendException exception) {
        return new ResponseEntity<>(exception.getMessage(), 
            HttpStatus.valueOf(Integer.parseInt(exception.getStatus())));
    }
    
}
