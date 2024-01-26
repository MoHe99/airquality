package com.moritzherrmann.airquality.repository;

import com.moritzherrmann.airquality.model.AirQualityForecast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirQualityForecastRepository extends JpaRepository<AirQualityForecast, Long>{}
