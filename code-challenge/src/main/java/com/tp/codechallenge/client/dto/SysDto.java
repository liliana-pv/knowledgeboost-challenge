package com.tp.codechallenge.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class SysDto extends CommonDto{
    private final static long serialVersionUID = 5918313869613156916L;
    
    @JsonProperty("type")
    private Integer type;

    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("country")
    private String country;
    
    @JsonProperty("sunrise")
    private Integer sunrise;
    
    @JsonProperty("sunset")
    private Integer sunset;

}
