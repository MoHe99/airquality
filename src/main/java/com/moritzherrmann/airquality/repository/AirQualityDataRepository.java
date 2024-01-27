package com.moritzherrmann.airquality.repository;

import com.moritzherrmann.airquality.model.AirQualityData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AirQualityDataRepository extends JpaRepository<AirQualityData, Long>{

    @Query("SELECT a FROM AirQualityData a WHERE a.timeRecorded IN (SELECT MAX(a2.timeRecorded) FROM AirQualityData a2 GROUP BY a2.cityStationIndex) ORDER BY a.cityStationIndex")
    List<AirQualityData> findAllLatest();

    List<AirQualityData> findByCityStationIndex(Long cityStationIndex);

    @Query("SELECT a FROM AirQualityData a WHERE a.cityStationIndex = :cityStationIndex AND FUNCTION('DATE', a.timeRecorded) = :date")
    Optional<AirQualityData> findByCityStationIndexAndDate(Long cityStationIndex, LocalDate date);
}
