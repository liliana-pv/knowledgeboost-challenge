package com.tp.codechallenge.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class WeatherDto extends CommonDto {
    private final static long serialVersionUID = 6931344867407269898L;

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("main")
    private String main;

    @JsonProperty("description")
    private String description;

    @JsonProperty("icon")
    private String icon;
    
}
