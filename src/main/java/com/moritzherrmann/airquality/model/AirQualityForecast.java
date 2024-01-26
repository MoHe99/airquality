package com.moritzherrmann.airquality.model;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "air_quality_forecasts")
public class AirQualityForecast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "city_index", referencedColumnName = "station_index", nullable = false)
    private City city;

    private LocalDate date;
    private String pollutant;
    private Integer min;
    private Integer max;
    private Integer avg;

    public AirQualityForecast() {
    }

    // Getter und Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPollutant() {
        return pollutant;
    }

    public void setPollutant(String pollutant) {
        this.pollutant = pollutant;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getAvg() {
        return avg;
    }

    public void setAvg(Integer avg) {
        this.avg = avg;
    }
}
