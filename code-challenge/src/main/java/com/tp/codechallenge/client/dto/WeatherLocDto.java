package com.tp.codechallenge.client.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class WeatherLocDto extends CommonDto {
    
    private final static long serialVersionUID = -2579426819746362234L;
    
    @JsonProperty("coord")
    private CoordDto coord;

    @JsonProperty("weather")
    private List<WeatherDto> weather;

    @JsonProperty("base")
    private String base;

    @JsonProperty("main")
    private MainDto main;

    @JsonProperty("visibility")
    private Integer visibility;

    @JsonProperty("wind")
    private WindDto wind;

    @JsonProperty("clouds")
    private CloudDto clouds;

    @JsonProperty("dt")
    private Integer dt;

    @JsonProperty("sys")
    private SysDto sys;

    @JsonProperty("timezone")
    private Integer timezone;

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;
    
    @JsonProperty("cod")
    private Integer cod;
   
}
