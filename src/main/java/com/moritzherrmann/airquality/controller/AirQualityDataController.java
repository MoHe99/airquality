package com.moritzherrmann.airquality.controller;

import com.moritzherrmann.airquality.model.AirQualityData;
import com.moritzherrmann.airquality.service.AirQualityDataService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirQualityDataController {

    @Autowired
    private AirQualityDataService airQualityService;

    @GetMapping("/latest-air-quality")
    public List<AirQualityData> getLatestAirQualityForEachCity() {
        return airQualityService.getLatestAirQualityForEachCity();
    }
}


