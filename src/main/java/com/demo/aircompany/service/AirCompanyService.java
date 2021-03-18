package com.demo.aircompany.service;

import com.demo.aircompany.model.AirCompany;
import com.demo.aircompany.model.dto.AirCompanyDto;

public interface AirCompanyService {

    AirCompany create(AirCompanyDto airCompanyDto);

    AirCompany getAirCompanyById(Long id);

    AirCompany getAirCompanyByName(String name);

    AirCompany updateAirCompany(Long id, AirCompanyDto airCompanyDto);

    void deleteAirCompanyById(Long id);

}
