package com.demo.aircompany.controller;

import com.demo.aircompany.constant.UrlConstants;
import com.demo.aircompany.model.Airplane;
import com.demo.aircompany.model.dto.AirplaneDto;
import com.demo.aircompany.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.demo.aircompany.constant.ControllerConstant.*;

@RestController
@RequestMapping(UrlConstants.API_V1 + UrlConstants.AIRPLANE)
public class AirplaneController {

    private final AirplaneService airplaneService;

    @Autowired
    public AirplaneController(AirplaneService airplaneService) {
        this.airplaneService = airplaneService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Airplane createAirPlane(@RequestBody AirplaneDto airplaneDto) {
        return airplaneService.create(airplaneDto);
    }

    @GetMapping(path = AIRPLANE_ID_MAPPING)
    @ResponseStatus(HttpStatus.OK)
    public Airplane getAirPlaneById(@PathVariable(AIRPLANE_ID_PATH_VARIABLE) Long id){
        return airplaneService.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Airplane getAirPlaneByName(@RequestParam String name){
        return airplaneService.getByName(name);
    }

    @DeleteMapping(path = AIRPLANE_ID_MAPPING)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAirPlaneById(@PathVariable(AIRPLANE_ID_PATH_VARIABLE) Long id) {
        airplaneService.deleteById(id);
    }

    @PutMapping(path = AIRPLANE_ID_MAPPING)
    @ResponseStatus(HttpStatus.OK)
    public Airplane updateAirPlane(@PathVariable(AIRPLANE_ID_PATH_VARIABLE) Long id,
                                       @RequestBody AirplaneDto airplaneDto) {
        return airplaneService.update(id, airplaneDto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Airplane updateAirplaneAirCompany(@RequestParam String airplaneName,
                                             @RequestParam String airCompanyName) {

        return airplaneService.reassignToAnotherAirCompany(airplaneName, airCompanyName);
    }

}
