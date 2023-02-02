package com.tp.codechallenge.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class CoordDto extends CommonDto {
    private final static long serialVersionUID = 5627941310841808857L;

    @JsonProperty("lon")
    private Double lon;

    @JsonProperty("lat")
    private Double lat;

}
