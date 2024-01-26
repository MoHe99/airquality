package com.moritzherrmann.airquality.repository;

import com.moritzherrmann.airquality.model.AirQualityData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirQualityDataRepository extends JpaRepository<AirQualityData, Long>{

    @Query("SELECT a FROM AirQualityData a WHERE a.timeRecorded IN (SELECT MAX(a2.timeRecorded) FROM AirQualityData a2 GROUP BY a2.cityStationIndex) ORDER BY a.cityStationIndex")
    List<AirQualityData> findAllLatest();
}
