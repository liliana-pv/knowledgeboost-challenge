package com.tp.codechallenge.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tp.codechallenge.dao.entities.WeatherResponseEntity;

public interface WeatherResponseRepository extends JpaRepository<WeatherResponseEntity, Long>{
    
}
