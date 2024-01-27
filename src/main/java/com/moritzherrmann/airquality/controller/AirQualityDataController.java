package com.moritzherrmann.airquality.controller;

import com.moritzherrmann.airquality.model.AirQualityData;
import com.moritzherrmann.airquality.service.AirQualityDataService;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirQualityDataController {

    private final AirQualityDataService airQualityService;

    public AirQualityDataController(AirQualityDataService airQualityService) {
        this.airQualityService = airQualityService;
    }

    @GetMapping("/airquality-data/latest")
    public List<AirQualityData> getAirQualityDataLatest() {
        return airQualityService.getAirQualityDataLatest();
    }

    @GetMapping("/airquality-data/{cityStationIndex}")
    public List<AirQualityData> getLatestAirQualityForEachCity(@PathVariable Long cityStationIndex) {
        return airQualityService.getAirQualityDataByIndex(cityStationIndex);
    }
}


