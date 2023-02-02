package com.tp.codechallenge.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class MainDto extends CommonDto {
    private final static long serialVersionUID = -1059761148335726687L;

    @JsonProperty("temp")
    private Double temp;

    @JsonProperty("feels_like")
    private Double feels_like;

    @JsonProperty("temp_min")
    private Double temp_min;

    @JsonProperty("temp_max")
    private Double temp_max;

    @JsonProperty("pressure")
    private Integer pressure;

    @JsonProperty("humidity")
    private Integer humidity;

    @JsonProperty("sea_level")
    private Integer sea_level;

    @JsonProperty("grnd_level")
    private Integer grnd_level;
    
}
