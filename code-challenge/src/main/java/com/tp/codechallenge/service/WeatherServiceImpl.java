package com.tp.codechallenge.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tp.codechallenge.client.OpenWeatherClient;
import com.tp.codechallenge.client.dto.WeatherLocDto;
import com.tp.codechallenge.dao.entities.WeatherResponseEntity;
import com.tp.codechallenge.dao.repository.WeatherResponseRepository;

@Service
public class WeatherServiceImpl implements IWeatherService {

    private final OpenWeatherClient openWeatherClient;

    private final WeatherResponseRepository weatherResponseRepository;

    @Value("${openweather.api.id}") String appId;

    @Autowired
    public WeatherServiceImpl(OpenWeatherClient openWeatherClient, WeatherResponseRepository weatherResponseRepository){
        this.openWeatherClient = openWeatherClient;
        this.weatherResponseRepository = weatherResponseRepository;
    }

    @Override
    public ResponseEntity<Object> findByCity(String cityName) {
        WeatherLocDto weatherLoc = openWeatherClient.getWeatherDataByCity(cityName, appId);
        WeatherResponseEntity weatherResponseEntity = new WeatherResponseEntity();
        weatherResponseEntity.setResponseCode(weatherLoc.getCod());
        weatherResponseEntity.setCityName(weatherLoc.getName());
        weatherResponseEntity.setCreatedAt(LocalDateTime.now());
        weatherResponseRepository.save(weatherResponseEntity);
        return ResponseEntity.ok(weatherLoc);
    }
    
    @Override
    public ResponseEntity<Object> findByCoordinates(Double latitude, Double longitude) {
        WeatherLocDto weatherLoc = openWeatherClient.getWeatherDataByCoordinates(String.valueOf(latitude), 
        String.valueOf(longitude), appId);
        WeatherResponseEntity weatherResponseEntity = new WeatherResponseEntity();
        weatherResponseEntity.setResponseCode(weatherLoc.getCod());
        weatherResponseEntity.setCityName(weatherLoc.getName());
        weatherResponseEntity.setCreatedAt(LocalDateTime.now());

        Optional<String> optCity = Optional.ofNullable(weatherLoc.getName());
        if(!optCity.isPresent())
        weatherResponseEntity.setCoordinates(weatherLoc.getCoord().getLat().toString().concat(",")
            .concat(weatherLoc.getCoord().getLon().toString()));

        weatherResponseRepository.save(weatherResponseEntity);
        return ResponseEntity.ok(weatherLoc);
    }
    
}
