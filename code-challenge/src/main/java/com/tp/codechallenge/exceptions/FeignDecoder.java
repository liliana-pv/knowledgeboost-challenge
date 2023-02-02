package com.tp.codechallenge.exceptions;

import java.io.IOException;
import java.io.InputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tp.codechallenge.exceptions.dto.FeignErrorDto;

import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        FeignErrorDto message = null;
        try (InputStream bodyIs = response.body()
            .asInputStream()) {
            ObjectMapper mapper = new ObjectMapper();
            message = mapper.readValue(bodyIs, FeignErrorDto.class);
        } catch (IOException e) {
            return new Exception(e.getMessage());
        }

        throw new ClientException(message.getCod(), message.getMessage());
    }
    
}
