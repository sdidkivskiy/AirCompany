package com.demo.aircompany.controller;

import com.demo.aircompany.constant.UrlConstants;
import com.demo.aircompany.model.Flight;
import com.demo.aircompany.model.dto.FlightDto;
import com.demo.aircompany.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.demo.aircompany.constant.ControllerConstant.*;

@RestController
@RequestMapping(UrlConstants.API_V1 + UrlConstants.FLIGHT)
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Flight create(@RequestBody FlightDto flightDto) {
        return flightService.create(flightDto);
    }

    @GetMapping(path = FLIGHT_ID_MAPPING)
    @ResponseStatus(HttpStatus.OK)
    public Flight getById(@PathVariable(FLIGHT_ID_PATH_VARIABLE) Long id){
        return flightService.getById(id);
    }

    @DeleteMapping(path = FLIGHT_ID_MAPPING)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable(FLIGHT_ID_PATH_VARIABLE) Long id) {
        flightService.deleteById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Flight> getByAirCompanyNameAndFlightStatus(@RequestParam String airCompanyName,
                                                           @RequestParam String status){

        return flightService.getAllFlightByAirCompanyNameAndFlightStatus(airCompanyName, status);
    }

    @GetMapping(path = FLIGHT_STATUS_AND_FLIGHT_TIME_MAPPING)
    @ResponseStatus(HttpStatus.OK)
    public List<Flight> getByFlightStatusAndFlightTime(@PathVariable String flightStatus,
                                                       @PathVariable String flightTime){

        return flightService.getAllFlightsByStatusAndFlightTime(flightStatus, flightTime);
    }

    @PutMapping(path = FLIGHT_ID_MAPPING)
    @ResponseStatus(HttpStatus.OK)
    public Flight updateFlightStatus(@PathVariable(FLIGHT_ID_PATH_VARIABLE) Long id,
                                     @RequestParam String flightStatus) {
        return flightService.changeFlightStatus(id, flightStatus);
    }
}
