package com.demo.aircompany.service;

import com.demo.aircompany.exception.DataNotFoundException;
import com.demo.aircompany.model.Country;

public interface CountryService {

    Country createCountry(Country country);

    Country getCountryByName(String name);

    Country getCountryById(Long id) throws DataNotFoundException;

    void deleteCountryById(Long id) throws DataNotFoundException;

    Country updateCountry(Long id, Country country) throws DataNotFoundException;

}
