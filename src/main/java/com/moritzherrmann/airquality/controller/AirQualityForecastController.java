package com.moritzherrmann.airquality.controller;

import com.moritzherrmann.airquality.model.AirQualityForecast;
import com.moritzherrmann.airquality.service.AirQualityForecastService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class AirQualityForecastController {

    private final AirQualityForecastService airQualityForecastService;

    public AirQualityForecastController(AirQualityForecastService airQualityForecastService) {
        this.airQualityForecastService = airQualityForecastService;
    }

    @GetMapping("/airquality-forecast/{cityStationIndex}")
    public List<AirQualityForecast> getLatestAirQualityForEachCity(@PathVariable Long cityStationIndex) {
        return airQualityForecastService.getAirQualityForecastByIndex(cityStationIndex);
    }
}


