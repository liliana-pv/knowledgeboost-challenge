package com.tp.codechallenge.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class WindDto extends CommonDto {
    private final static long serialVersionUID = 8300081688384609779L;
    
    @JsonProperty("speed")
    private Double speed;
    
    @JsonProperty("deg")
    private Integer deg;
    
    @JsonProperty("gust")
    private Double gust;

}
