package com.moritzherrmann.airquality.service;

import com.moritzherrmann.airquality.model.City;
import com.moritzherrmann.airquality.repository.CityRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }
}
