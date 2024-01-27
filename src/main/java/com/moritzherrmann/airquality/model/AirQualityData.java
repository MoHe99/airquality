package com.moritzherrmann.airquality.model;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "air_quality_data")
public class AirQualityData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city_station_index", nullable = false)
    private Long cityStationIndex;

    @Column(nullable = false)
    private Integer aqi;

    @Column(name = "time_recorded")
    private LocalDateTime timeRecorded;

    @Column(name = "o3")
    private Double o3;

    @Column(name = "pm10")
    private Double pm10;

    @Column(name = "pm25")
    private Double pm25;

    @Column(name = "no2")
    private Double no2;

    public AirQualityData() {}

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getCityStationIndex() { return cityStationIndex; }

    public void setCityStationIndex(Long cityStationIndex) { this.cityStationIndex = cityStationIndex; }

    public Integer getAqi() { return aqi; }

    public void setAqi(Integer aqi) { this.aqi = aqi; }

    public LocalDateTime getTimeRecorded() { return timeRecorded; }

    public void setTimeRecorded(LocalDateTime timeRecorded) { this.timeRecorded = timeRecorded; }

    public Double getO3() { return o3; }
    
    public void setO3(Double o3) { this.o3 = o3; }

    public Double getPm10() { return pm10; }

    public void setPm10(Double pm10) { this.pm10 = pm10; }

    public Double getPm25() { return pm25; }

    public void setPm25(Double pm25) { this.pm25 = pm25; }

    public Double getNo2() { return no2; }

    public void setNo2(Double no2) { this.no2 = no2; }
}
