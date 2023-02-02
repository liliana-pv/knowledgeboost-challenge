package com.tp.codechallenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tp.codechallenge.service.WeatherServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Validated
@Tag(name = "Weather Controller", description = "Methods to get weather data for a specific location.")
@CrossOrigin
public class WeatherController {
    
    private final WeatherServiceImpl weatherService;

    @Autowired
    public WeatherController(WeatherServiceImpl weatherService){
        this.weatherService = weatherService;
    }

    @Operation(summary = "Retrieve weather data by city name")
    @GetMapping("/weather/city/{cityName}")
    public ResponseEntity<Object> getWeatherByCity(@PathVariable("cityName") String cityName){
        return weatherService.findByCity(cityName);
    }
    
    @Operation(summary = "Retrieve weather data by geographical coordinates")
    @GetMapping("/weather/latitude/{latitude}/longitude/{longitude}")
    public ResponseEntity<Object> getWeatherDataByCoordinates(@PathVariable("latitude") Double lat, 
        @PathVariable("longitude") Double lon){
       return weatherService.findByCoordinates(lat, lon);
    }
}
