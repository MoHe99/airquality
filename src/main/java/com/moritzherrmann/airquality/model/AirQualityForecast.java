package com.moritzherrmann.airquality.model;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "air_quality_forecasts")
public class AirQualityForecast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city_station_index", nullable = false)
    private Long cityStationIndex;

    @Column(name = "forecast_date")
    private LocalDate forecastDate;

    @Column(name = "o3")
    private Double o3;

    @Column(name = "pm10")
    private Double pm10;

    @Column(name = "pm25")
    private Double pm25;

    public AirQualityForecast() {}

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getCityStationIndex() { return cityStationIndex; }

    public void setCityStationIndex(Long cityStationIndex) { this.cityStationIndex = cityStationIndex; }

    public LocalDate getForecastDate() { return forecastDate; }

    public void setForecastDate(LocalDate forecastDate) { this.forecastDate = forecastDate; }

    public Double getO3() { return o3; }

    public void setO3(Double o3) { this.o3 = o3; }

    public Double getPm10() { return pm10; }

    public void setPm10(Double pm10) { this.pm10 = pm10; }

    public Double getPm25() { return pm25; }

    public void setPm25(Double pm25) { this.pm25 = pm25; }
}
