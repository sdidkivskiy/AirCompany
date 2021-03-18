package com.demo.aircompany.service.impl;

import com.demo.aircompany.constant.ErrorMessage;
import com.demo.aircompany.exception.DataNotFoundException;
import com.demo.aircompany.model.Country;
import com.demo.aircompany.repository.CountryRepository;
import com.demo.aircompany.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Transactional
    @Override
    public Country createCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country getCountryByName(String name) {

        Country country = countryRepository.findByName(name);

        if(country != null) {
            return country;
        } else {
            throw new DataNotFoundException(ErrorMessage.COUNTRY_WITH_SUCH_NAME_DOES_NOT_EXISTS);
        }
    }

    @Override
    public Country getCountryById(Long id) throws DataNotFoundException {
        return countryRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(ErrorMessage.COUNTRY_WITH_SUCH_ID_DOES_NOT_EXISTS));
    }

    @Transactional
    @Override
    public void deleteCountryById(Long id) throws DataNotFoundException {

        if(countryRepository.existsById(id)) {
            countryRepository.delete(getCountryById(id));
        } else {
            throw new DataNotFoundException(ErrorMessage.COUNTRY_WITH_SUCH_ID_DOES_NOT_EXISTS);
        }
    }

    @Transactional
    @Override
    public Country updateCountry(Long id, Country country) throws DataNotFoundException {

        if(countryRepository.existsById(id)) {
            country.setId(id);
            return countryRepository.save(country);
        } else {
            throw new DataNotFoundException(ErrorMessage.COUNTRY_WITH_SUCH_ID_DOES_NOT_EXISTS);
        }
    }
}
