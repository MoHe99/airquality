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

    public AirQualityData() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCityStationIndex() { return cityStationIndex; }

    public void setCityStationIndex(Long cityStationIndex) {
        this.cityStationIndex = cityStationIndex;
    }

    public Integer getAqi() {
        return aqi;
    }

    public void setAqi(Integer aqi) {
        this.aqi = aqi;
    }

    public LocalDateTime getTimeRecorded() { return timeRecorded; }

    public void setTimeRecorded(LocalDateTime timeRecorded) {
        this.timeRecorded = timeRecorded;
    }
}
