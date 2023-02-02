package com.tp.codechallenge.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class CloudDto extends CommonDto {
    private final static long serialVersionUID = 1134977023097387008L;

    @JsonProperty("all")
    private Integer all;

}
