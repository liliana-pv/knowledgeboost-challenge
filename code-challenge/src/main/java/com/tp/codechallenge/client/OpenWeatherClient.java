package com.tp.codechallenge.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tp.codechallenge.client.dto.WeatherLocDto;


@FeignClient(value = "openweatherapi", url = "https://api.openweathermap.org/data/2.5")
public interface OpenWeatherClient {
    
    @RequestMapping(method = RequestMethod.GET, value = "/weather", produces = "application/json")
    WeatherLocDto getWeatherDataByCity(@RequestParam("q") String cityName, @RequestParam("appid") String appId);


    @RequestMapping(method = RequestMethod.GET, value = "/weather", produces = "application/json")
    WeatherLocDto getWeatherDataByCoordinates(@RequestParam(name="lat") String lat,
        @RequestParam(name="lon") String lon, @RequestParam("appid") String appId);

}
