package com.demo.aircompany.service.impl;

import com.demo.aircompany.constant.EnumString;
import com.demo.aircompany.constant.ErrorMessage;
import com.demo.aircompany.exception.DataNotFoundException;
import com.demo.aircompany.exception.IncorrectRelationshipsException;
import com.demo.aircompany.exception.IncorrectTypeException;
import com.demo.aircompany.model.AirCompany;
import com.demo.aircompany.model.Airplane;
import com.demo.aircompany.model.Flight;
import com.demo.aircompany.model.FlightStatus;
import com.demo.aircompany.model.dto.FlightDto;
import com.demo.aircompany.repository.FlightRepository;
import com.demo.aircompany.service.AirCompanyService;
import com.demo.aircompany.service.AirplaneService;
import com.demo.aircompany.service.CountryService;
import com.demo.aircompany.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final AirCompanyService airCompanyService;
    private final AirplaneService airplaneService;
    private final CountryService countryService;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository, AirCompanyService airCompanyService, AirplaneService airplaneService, CountryService countryService) {
        this.flightRepository = flightRepository;
        this.airCompanyService = airCompanyService;
        this.airplaneService = airplaneService;
        this.countryService = countryService;
    }

    @Override
    public Flight create(FlightDto flightDto) {

        AirCompany airCompany = airCompanyService.getAirCompanyByName(flightDto.getAirCompanyName());
        Airplane airplane = airplaneService.getByName(flightDto.getAirplaneName());

        if(airplane.getAirCompany().getId().equals(airCompany.getId())) {

            Flight flight = new Flight();

            if(flightDto.getStatus() != null) {
                flight.setStatus(getFlightStatus(flightDto.getStatus()));
            } else {
                flight.setStatus(FlightStatus.PENDING);
            }

            flight.setAirplane(airplaneService.getByName(flightDto.getAirplaneName()));
            flight.setAirCompany(airCompanyService.getAirCompanyByName(flightDto.getAirCompanyName()));
            flight.setDepartureCountry(countryService.getCountryByName(flightDto.getDepartureCountryName()));
            flight.setDestinationCountry(countryService.getCountryByName(flightDto.getDestinationCountryName()));
            flight.setDistance(flightDto.getDistance());
            flight.setEstimatedTime(flightDto.getEstimatedTime());
            flight.setCreatedAt(LocalDateTime.now());

            if(flightDto.getStartedAt() != null) {
                flight.setStartedAt(flightDto.getStartedAt());
            }

            return flightRepository.save(flight);
        } else {
            throw new IncorrectRelationshipsException("Airplane with name " + airplane.getName() + " does not refer to such company!");
        }

    }

    @Override
    public Flight getById(Long id) {
        return flightRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(ErrorMessage.FLIGHT_WITH_SUCH_ID_DOES_NOT_EXISTS));
    }

    @Override
    public void deleteById(Long id) {
        if(flightRepository.existsById(id)) {
            flightRepository.delete(getById(id));
        } else {
            throw new DataNotFoundException(ErrorMessage.FLIGHT_WITH_SUCH_ID_DOES_NOT_EXISTS);
        }
    }

    @Override
    public List<Flight> getAllFlightByAirCompanyNameAndFlightStatus(String airCompanyName, String flightStatus) {

        AirCompany airCompany = airCompanyService.getAirCompanyByName(airCompanyName);
        FlightStatus status = getFlightStatus(flightStatus);

        return flightRepository.findAllByAirCompanyAndStatus(airCompany, status);
    }

    @Override
    public List<Flight> getAllFlightsByStatusAndFlightTime(String flightStatus, String flightTime) {

        return flightRepository.findAllByStatusAndFlightTime(getFlightStatus(flightStatus).toString(), flightTime);
    }

    @Override
    public Flight changeFlightStatus(Long id, String flightStatus) {

        Flight flight = getById(id);
        FlightStatus status = getFlightStatus(flightStatus);
        flight.setStatus(status);

        if(status.equals(FlightStatus.DELAYED)) {
            flight.setDelayStartedAt(LocalDateTime.now());
        }
        if(status.equals(FlightStatus.ACTIVE)) {
            flight.setStartedAt(LocalDateTime.now());
        }
        if(status.equals(FlightStatus.COMPLETED)) {
            String[] estimatedTime = flight.getEstimatedTime().split(":");
            flight.setEndedAt(flight.getStartedAt()
                    .plusHours(Long.parseLong(estimatedTime[0]))
                    .plusMinutes(Long.parseLong(estimatedTime[1]))
                    .plusSeconds(Long.parseLong(estimatedTime[2]))
            );
        }

        return flightRepository.save(flight);
    }

    private FlightStatus getFlightStatus(String flightStatus) {
        if(!flightStatus.toLowerCase().equals(EnumString.ACTIVE)
                && !flightStatus.toLowerCase().equals(EnumString.COMPLETED)
                && !flightStatus.toLowerCase().equals(EnumString.DELAYED)
                && !flightStatus.toLowerCase().equals(EnumString.PENDING)
        ) {
            throw new IncorrectTypeException(ErrorMessage.INCORRECT_FLIGHT_STATUS);
        }
        else if(flightStatus.toLowerCase().equals(EnumString.ACTIVE)) {
            return FlightStatus.ACTIVE;
        }
        else if(flightStatus.toLowerCase().equals(EnumString.COMPLETED)) {
            return FlightStatus.COMPLETED;
        }
        else if(flightStatus.toLowerCase().equals(EnumString.DELAYED)) {
            return FlightStatus.DELAYED;
        }
        else {
            return FlightStatus.PENDING;
        }
    }

}
