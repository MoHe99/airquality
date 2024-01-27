package com.moritzherrmann.airquality.service;

import com.moritzherrmann.airquality.model.AirQualityForecast;
import com.moritzherrmann.airquality.repository.AirQualityForecastRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirQualityForecastService {

    private final AirQualityForecastRepository airQualityForecastRepository;

    public AirQualityForecastService(AirQualityForecastRepository airQualityForecastRepository) {
        this.airQualityForecastRepository = airQualityForecastRepository;
    }

    public List<AirQualityForecast> getAirQualityForecastByIndex(Long cityStationIndex) {
        return airQualityForecastRepository.findByCityStationIndex(cityStationIndex);
    }
}

