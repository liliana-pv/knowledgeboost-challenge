package com.tp.codechallenge.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tp.codechallenge.client.OpenWeatherClient;
import com.tp.codechallenge.client.dto.WeatherLocDto;
import com.tp.codechallenge.dao.entities.WeatherResponseEntity;
import com.tp.codechallenge.dao.repository.WeatherResponseRepository;
import com.tp.codechallenge.exceptions.BackendException;
import com.tp.codechallenge.exceptions.ClientException;

@Service
public class WeatherServiceImpl implements IWeatherService {

    private final Logger logger = LogManager.getLogger(WeatherServiceImpl.class);

    private final OpenWeatherClient openWeatherClient;

    private final WeatherResponseRepository weatherResponseRepository;

    @Value("${openweather.api.id}") 
    private String appId;

    @Autowired
    public WeatherServiceImpl(OpenWeatherClient openWeatherClient, WeatherResponseRepository weatherResponseRepository){
        this.openWeatherClient = openWeatherClient;
        this.weatherResponseRepository = weatherResponseRepository;
    }

    @Override
    public ResponseEntity<Object> findByCity(String cityName) {
        WeatherLocDto weatherLoc;
        WeatherResponseEntity weatherResponseEntity = new WeatherResponseEntity();
        try{
            logger.info("Start getting weather data by city name");
            weatherLoc = openWeatherClient.getWeatherDataByCity(cityName, appId);
            weatherResponseEntity.setResponseCode(weatherLoc.getCod());
            weatherResponseEntity.setCityName(weatherLoc.getName());
            weatherResponseEntity.setCreatedAt(LocalDateTime.now());
            weatherResponseRepository.save(weatherResponseEntity);
            logger.info("Saved success response");
            return ResponseEntity.ok(weatherLoc);
        } catch (ClientException be){
            logger.error("Error invoking openweather api");
            weatherResponseEntity.setResponseCode(Integer.parseInt(be.getStatus()));
            weatherResponseEntity.setResponseMsg(be.getMessage());
            weatherResponseEntity.setCreatedAt(LocalDateTime.now());
            weatherResponseRepository.save(weatherResponseEntity);
            throw new BackendException(be.getStatus(), be.getMessage());
        } catch (Exception e) {
            logger.error("Cannot invoke openweather api");
            throw new BackendException(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "An error occurred while processing the request");
        }
    }
    
    @Override
    public ResponseEntity<Object> findByCoordinates(Double latitude, Double longitude) {
        WeatherLocDto weatherLoc;
        WeatherResponseEntity weatherResponseEntity = new WeatherResponseEntity();
        try{
            logger.info("Start getting weather data by coordinates");

            weatherLoc = openWeatherClient.getWeatherDataByCoordinates(String.valueOf(latitude), 
            String.valueOf(longitude), appId);
            weatherResponseEntity = new WeatherResponseEntity();
            weatherResponseEntity.setResponseCode(weatherLoc.getCod());
            weatherResponseEntity.setCityName(weatherLoc.getName());
            weatherResponseEntity.setCreatedAt(LocalDateTime.now());

            Optional<String> optCity = Optional.ofNullable(weatherLoc.getName());
            if(!optCity.isPresent())
            weatherResponseEntity.setCoordinates(weatherLoc.getCoord().getLat().toString().concat(",")
                .concat(weatherLoc.getCoord().getLon().toString()));

            weatherResponseRepository.save(weatherResponseEntity);
            logger.info("Saved success response");
            return ResponseEntity.ok(weatherLoc);
        } catch (ClientException be){
            logger.error("Error invoking openweather api");
            weatherResponseEntity.setResponseCode(Integer.parseInt(be.getStatus()));
            weatherResponseEntity.setResponseMsg(be.getMessage());
            weatherResponseEntity.setCreatedAt(LocalDateTime.now());
            weatherResponseRepository.save(weatherResponseEntity);
            throw new BackendException(be.getStatus(), be.getMessage());
        } catch (Exception e) {
            logger.error("Cannot invoke openweather api");
            throw new BackendException(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "An error occurred while processing the request");
        }
    }
    
}
