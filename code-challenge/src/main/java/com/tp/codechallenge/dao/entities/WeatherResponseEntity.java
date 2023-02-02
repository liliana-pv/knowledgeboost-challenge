package com.tp.codechallenge.dao.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "weather_response", schema = "tp", catalog = "")
@Data
public class WeatherResponseEntity {
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "weather_response_id")
    private Long weatherResponseId;

    @Column(name = "response_code")
    private Integer responseCode;

    @Column(name = "response_msg")
    private String responseMsg;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "coord")
    private String coordinates;

}
