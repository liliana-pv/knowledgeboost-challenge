package com.tp.codechallenge.config;

import org.springframework.context.annotation.Bean;

import feign.Logger;
import feign.Logger.Level;

public class FeignConfig {
    
    @Bean
    Level feignLoggerLevel() {
        return Logger.Level.NONE;
    }
}
