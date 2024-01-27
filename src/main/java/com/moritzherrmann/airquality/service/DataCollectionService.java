package com.moritzherrmann.airquality.service;

import com.moritzherrmann.airquality.model.AirQualityData;
import com.moritzherrmann.airquality.model.AirQualityForecast;
import com.moritzherrmann.airquality.model.AirQualityApiResponse;
import com.moritzherrmann.airquality.model.City;
import com.moritzherrmann.airquality.repository.CityRepository;
import com.moritzherrmann.airquality.repository.AirQualityDataRepository;
import com.moritzherrmann.airquality.repository.AirQualityForecastRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class DataCollectionService {

    @Value("${airquality.api.token}")
    private String airQualityApiToken;

    private final RestTemplate restTemplate = new RestTemplate();

    private final CityRepository cityRepository;
    private final AirQualityDataRepository airQualityDataRepository;
    private final AirQualityForecastRepository forecastDataRepository;

    public DataCollectionService(CityRepository cityRepository, AirQualityDataRepository airQualityDataRepository, AirQualityForecastRepository forecastDataRepository) {
        this.cityRepository = cityRepository;
        this.airQualityDataRepository = airQualityDataRepository;
        this.forecastDataRepository = forecastDataRepository;
    }

    @Transactional
    @Scheduled(cron = "0 0 6,12,18,0 * * *")
    public void collectData() {
        List<City> cities = cityRepository.findAll();
        for (City city : cities) {
            try {
                String API_URL = "https://api.waqi.info/feed/{cityName}/?token=" + airQualityApiToken;
                String apiUrlWithCity = API_URL.replace("{cityName}", city.getName().toLowerCase());
                AirQualityApiResponse response = restTemplate.getForObject(apiUrlWithCity, AirQualityApiResponse.class);
                
                if (response != null && "ok".equals(response.getStatus())) {
                    forecastDataRepository.deleteByCityStationIndex(city.getStationIndex());
                    processAirQualityData(response, city.getStationIndex());
                    processAirQualityForecast(response.getData().getForecast(), city.getStationIndex());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void processAirQualityData(AirQualityApiResponse response, Long cityStationIndex) {
        AirQualityData airQualityData = getAirQualityData(response);
        LocalDate date = airQualityData.getTimeRecorded().toLocalDate();

        Optional<AirQualityData> existingData = airQualityDataRepository
                .findByCityStationIndexAndDate(airQualityData.getCityStationIndex(), date);

        if (existingData.isPresent()) {
            AirQualityData updatedData = existingData.get();
            updatedData.setAqi(airQualityData.getAqi());
            updatedData.setO3(airQualityData.getO3());
            updatedData.setPm10(airQualityData.getPm10());
            updatedData.setPm25(airQualityData.getPm25());
            updatedData.setNo2(airQualityData.getNo2());
            airQualityDataRepository.save(updatedData);
        } else {
            airQualityDataRepository.save(airQualityData);
        }
    }

    private static AirQualityData getAirQualityData(AirQualityApiResponse response) {
        AirQualityData airQualityData = new AirQualityData();
        airQualityData.setCityStationIndex(response.getData().getIdx());
        airQualityData.setAqi(response.getData().getAqi());
        String timeRecordedString = response.getData().getTime().getIso();
        OffsetDateTime odt = OffsetDateTime.parse(timeRecordedString, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        LocalDateTime localTimeRecorded = odt.toLocalDateTime();
        airQualityData.setTimeRecorded(localTimeRecorded);

        if (response.getData().getIaqi() != null) {
            if (response.getData().getIaqi().getO3() != null) {
                airQualityData.setO3(response.getData().getIaqi().getO3().getV());
            }
            if (response.getData().getIaqi().getPm10() != null) {
                airQualityData.setPm10(response.getData().getIaqi().getPm10().getV());
            }
            if (response.getData().getIaqi().getPm25() != null) {
                airQualityData.setPm25(response.getData().getIaqi().getPm25().getV());
            }
            if (response.getData().getIaqi().getNo2() != null) {
                airQualityData.setNo2(response.getData().getIaqi().getNo2().getV());
            }
        }
        return airQualityData;
    }

    private void processAirQualityForecast(AirQualityApiResponse.Data.Forecast forecast, Long cityStationIndex) {
        if (forecast != null && forecast.getDaily() != null) {            
            List<AirQualityApiResponse.Data.Pollutant> o3List = forecast.getDaily().getO3();
            List<AirQualityApiResponse.Data.Pollutant> pm10List = forecast.getDaily().getPm10();
            List<AirQualityApiResponse.Data.Pollutant> pm25List = forecast.getDaily().getPm25();
    
            if (o3List.size() == pm10List.size() && o3List.size() == pm25List.size()) {
                LocalDate currentDate = LocalDate.now();
    
                for (int i = 0; i < o3List.size(); i++) {
                    LocalDate forecastDate = LocalDate.parse(forecast.getDaily().getO3().get(i).getDay());
                    if (forecastDate.isAfter(currentDate)) {
                        AirQualityApiResponse.Data.Pollutant o3 = o3List.get(i);
                        AirQualityApiResponse.Data.Pollutant pm10 = pm10List.get(i);
                        AirQualityApiResponse.Data.Pollutant pm25 = pm25List.get(i);
    
                        saveForecastData(o3, pm10, pm25, cityStationIndex, forecastDate);
                    }
                }
            }
        }
    }
    
    private void saveForecastData(AirQualityApiResponse.Data.Pollutant o3, AirQualityApiResponse.Data.Pollutant pm10, AirQualityApiResponse.Data.Pollutant pm25, Long cityStationIndex, LocalDate forecastDate) {
        AirQualityForecast forecast = new AirQualityForecast();
        forecast.setCityStationIndex(cityStationIndex);
        forecast.setForecastDate(forecastDate);
        forecast.setO3(o3.getAvg());
        forecast.setPm10(pm10.getAvg());
        forecast.setPm25(pm25.getAvg());
    
        forecastDataRepository.save(forecast);
    }
}
