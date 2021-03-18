package com.demo.aircompany.repository;

import com.demo.aircompany.model.AirCompany;
import com.demo.aircompany.model.Flight;
import com.demo.aircompany.model.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findAllByAirCompanyAndStatus(AirCompany airCompany, FlightStatus status);

    @Query(
            value = "select * from flight where flight.status = ?1 and substring_index(flight.estimated_time, ':', 1) > ?2",
            nativeQuery = true
    )
    List<Flight> findAllByStatusAndFlightTime(String flightStatus,
                                              String flightHours);
}
