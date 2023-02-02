package com.tp.codechallenge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tp.codechallenge.exceptions.FeignDecoder;

import feign.codec.ErrorDecoder;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SpringConfig {


    @Bean
    public OpenAPI springWeatherServiceAPI() {
        return new OpenAPI().info(new Info()
                .title("Weather Service API")
                .description("Spring Boot application to get weather data."));

    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new FeignDecoder();
    }
   
}
