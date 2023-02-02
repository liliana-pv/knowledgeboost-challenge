package com.tp.codechallenge.service;

import org.springframework.http.ResponseEntity;

public interface IWeatherService {

    public ResponseEntity<Object> findByCity(String cityName);

    public ResponseEntity<Object> findByCoordinates(Double latitude, Double longitude);
    
}
