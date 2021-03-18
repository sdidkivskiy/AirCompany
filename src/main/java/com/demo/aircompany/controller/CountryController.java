package com.demo.aircompany.controller;

import com.demo.aircompany.constant.ControllerConstant;
import com.demo.aircompany.constant.UrlConstants;
import com.demo.aircompany.model.Country;
import com.demo.aircompany.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UrlConstants.API_V1 + UrlConstants.COUNTRY_ENDPOINT)
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Country createCountry(@RequestBody Country country) {
        return countryService.createCountry(country);
    }

    @GetMapping(path = ControllerConstant.COUNTRY_ID_MAPPING)
    @ResponseStatus(HttpStatus.OK)
    public Country getCountryById(@PathVariable(ControllerConstant.COUNTRY_ID_PATH_VARIABLE) Long id){
        return countryService.getCountryById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Country getCountryByName(@RequestParam String name){
        return countryService.getCountryByName(name);
    }

    @DeleteMapping(path = ControllerConstant.COUNTRY_ID_MAPPING)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCountryById(@PathVariable(ControllerConstant.COUNTRY_ID_PATH_VARIABLE) Long id) {
        countryService.deleteCountryById(id);
    }

    @PutMapping(path = ControllerConstant.COUNTRY_ID_MAPPING)
    @ResponseStatus(HttpStatus.OK)
    public Country updateCountry(@PathVariable(ControllerConstant.COUNTRY_ID_PATH_VARIABLE) Long id,
                                 @RequestBody Country country) {
        return countryService.updateCountry(id, country);
    }

}
