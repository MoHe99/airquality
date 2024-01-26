package com.moritzherrmann.airquality.controller;

import com.moritzherrmann.airquality.model.City;
import com.moritzherrmann.airquality.service.CityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/cities")
    public List<City> getAll() {
        return cityService.getAllCities();
    }
}
