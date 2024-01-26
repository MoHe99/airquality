package com.moritzherrmann.airquality.service;

import com.moritzherrmann.airquality.model.AirQualityData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.moritzherrmann.airquality.model.City;
import com.moritzherrmann.airquality.repository.CityRepository;
import com.moritzherrmann.airquality.repository.AirQualityDataRepository;
import com.moritzherrmann.airquality.model.AirQualityApiResponse;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class DataCollectionService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private AirQualityDataRepository airQualityDataRepository;

    @Scheduled(cron = "0 0 0,12 * * *") // 12 am and pm
    //@Scheduled(cron = "0 * * * * *")
    public void collectData() {
        List<City> cities = cityRepository.findAll();
        System.out.println("Fetching...");

        for (City city : cities) {
            try {
                String API_URL = "https://api.waqi.info/feed/{cityName}/?token=948ff3ae8201a78abdcf31793b6a48f49147ecc6";
                String apiUrlWithCity = API_URL.replace("{cityName}", city.getName().toLowerCase());
                AirQualityApiResponse response = restTemplate.getForObject(apiUrlWithCity, AirQualityApiResponse.class);

                if (response != null && "ok".equals(response.getStatus())) {
                    AirQualityData airQualityData = getAirQualityData(response);
                    airQualityDataRepository.save(airQualityData);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Done!");
    }

    private static AirQualityData getAirQualityData(AirQualityApiResponse response) {
        AirQualityData airQualityData = new AirQualityData();
        airQualityData.setCityStationIndex(response.getData().getIdx());
        airQualityData.setAqi(response.getData().getAqi());
        String timeRecordedString = response.getData().getTime().getIso();
        OffsetDateTime odt = OffsetDateTime.parse(timeRecordedString, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        LocalDateTime localTimeRecorded = odt.toLocalDateTime();
        airQualityData.setTimeRecorded(localTimeRecorded);
        return airQualityData;
    }
}
