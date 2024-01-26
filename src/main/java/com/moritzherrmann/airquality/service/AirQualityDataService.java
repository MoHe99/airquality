package com.moritzherrmann.airquality.service;

import com.moritzherrmann.airquality.model.AirQualityData;
import com.moritzherrmann.airquality.repository.AirQualityDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirQualityDataService {

    private final AirQualityDataRepository airQualityDataRepository;

    public AirQualityDataService(AirQualityDataRepository airQualityDataRepository) {
        this.airQualityDataRepository = airQualityDataRepository;
    }

    public List<AirQualityData> getLatestAirQualityForEachCity() {
        return airQualityDataRepository.findAllLatest();
    }
}

