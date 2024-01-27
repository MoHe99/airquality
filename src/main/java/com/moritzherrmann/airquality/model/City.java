package com.moritzherrmann.airquality.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "station_index", nullable = false)
    private Long stationIndex;

    @Column(name = "geo_latitude", nullable = false)
    private Double geoLatitude;

    @Column(name = "geo_longitude", nullable = false)
    private Double geoLongitude;

    public City() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGeoLatitude() {
        return geoLatitude;
    }

    public void setGeoLatitude(Double geoLatitude) {
        this.geoLatitude = geoLatitude;
    }

    public Double getGeoLongitude() {
        return geoLongitude;
    }

    public void setGeoLongitude(Double geoLongitude) {
        this.geoLongitude = geoLongitude;
    }

    public Long getStationIndex() {
        return stationIndex;
    }

    public void setStationIndex(Long stationIndex) {
        this.stationIndex = stationIndex;
    }
}
