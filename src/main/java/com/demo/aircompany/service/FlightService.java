package com.demo.aircompany.service;

import com.demo.aircompany.model.Flight;
import com.demo.aircompany.model.FlightStatus;
import com.demo.aircompany.model.dto.FlightDto;

import java.util.List;

public interface FlightService {

    Flight create(FlightDto flightDto);

    Flight getById(Long id);

    void deleteById(Long id);

    List<Flight> getAllFlightByAirCompanyNameAndFlightStatus(String airCompanyName, String flightStatus);

    List<Flight> getAllFlightsByStatusAndFlightTime(String flightStatus, String flightTime);

    Flight changeFlightStatus(Long id, String flightStatus);

}
