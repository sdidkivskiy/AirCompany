package com.demo.aircompany.service;

import com.demo.aircompany.model.Airplane;
import com.demo.aircompany.model.dto.AirplaneDto;

public interface AirplaneService {

    Airplane create(AirplaneDto airplaneDto);

    Airplane getById(Long id);

    Airplane getByName(String name);

    Airplane update(Long id, AirplaneDto airplaneDto);

    void deleteById(Long id);

    Airplane reassignToAnotherAirCompany(String airplaneName, String airCompanyName);

}
