package com.demo.aircompany.controller;

import com.demo.aircompany.constant.ControllerConstant;
import com.demo.aircompany.constant.UrlConstants;
import com.demo.aircompany.model.AirCompany;
import com.demo.aircompany.model.dto.AirCompanyDto;
import com.demo.aircompany.service.AirCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.demo.aircompany.constant.ControllerConstant.*;

@RestController
@RequestMapping(UrlConstants.API_V1 + UrlConstants.AIRCOMPANY)
public class AirCompanyController {

    private final AirCompanyService airCompanyService;

    @Autowired
    public AirCompanyController(AirCompanyService airCompanyService) {
        this.airCompanyService = airCompanyService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AirCompany createAirCompany(@RequestBody AirCompanyDto airCompanyDto) {
        return airCompanyService.create(airCompanyDto);
    }

    @GetMapping(path = AIR_COMPANY_ID_MAPPING)
    @ResponseStatus(HttpStatus.OK)
    public AirCompany getAirCompanyById(@PathVariable(AIR_COMPANY_ID_PATH_VARIABLE) Long id){
        return airCompanyService.getAirCompanyById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public AirCompany getAirCompanyByName(@RequestParam String name){
        return airCompanyService.getAirCompanyByName(name);
    }

    @DeleteMapping(path = AIR_COMPANY_ID_MAPPING)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAirCompanyById(@PathVariable(AIR_COMPANY_ID_PATH_VARIABLE) Long id) {
        airCompanyService.deleteAirCompanyById(id);
    }

    @PutMapping(path = AIR_COMPANY_ID_MAPPING)
    @ResponseStatus(HttpStatus.OK)
    public AirCompany updateAirCompany(@PathVariable(AIR_COMPANY_ID_PATH_VARIABLE) Long id,
                                       @RequestBody AirCompanyDto airCompanyDto) {
        return airCompanyService.updateAirCompany(id, airCompanyDto);
    }

}
