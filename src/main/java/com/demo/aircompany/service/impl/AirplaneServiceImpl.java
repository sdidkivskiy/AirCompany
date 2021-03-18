package com.demo.aircompany.service.impl;

import com.demo.aircompany.constant.EnumString;
import com.demo.aircompany.constant.ErrorMessage;
import com.demo.aircompany.exception.DataNotFoundException;
import com.demo.aircompany.exception.IncorrectTypeException;
import com.demo.aircompany.model.AirCompany;
import com.demo.aircompany.model.Airplane;
import com.demo.aircompany.model.AirplaneType;
import com.demo.aircompany.model.dto.AirplaneDto;
import com.demo.aircompany.repository.AirplaneRepository;
import com.demo.aircompany.service.AirCompanyService;
import com.demo.aircompany.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirplaneServiceImpl implements AirplaneService {

    private final AirplaneRepository airplaneRepository;
    private final AirCompanyService airCompanyService;

    @Autowired
    public AirplaneServiceImpl(AirplaneRepository airplaneRepository, AirCompanyService airCompanyService) {
        this.airplaneRepository = airplaneRepository;
        this.airCompanyService = airCompanyService;
    }

    @Override
    public Airplane create(AirplaneDto airplaneDto) {

        Airplane airplane = new Airplane();

        return airplaneRepository.save(mapDtoToEntity(airplane, airplaneDto));
    }

    @Override
    public Airplane getById(Long id) {
        return airplaneRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(ErrorMessage.AIRPLANE_WITH_SUCH_ID_DOES_NOT_EXISTS));
    }

    @Override
    public Airplane getByName(String name) {
        Airplane airplane = airplaneRepository.findByName(name);

        if(airplane != null) {
            return airplane;
        } else {
            throw new DataNotFoundException(ErrorMessage.AIRPLANE_WITH_SUCH_NAME_DOES_NOT_EXISTS);
        }
    }

    @Override
    public Airplane update(Long id, AirplaneDto airplaneDto) {

        Airplane airplane = getById(id);
        airplane.setId(id);
        return airplaneRepository.save(mapDtoToEntity(airplane, airplaneDto));
    }

    @Override
    public void deleteById(Long id) {
        if(airplaneRepository.existsById(id)) {
            airplaneRepository.delete(getById(id));
        } else {
            throw new DataNotFoundException(ErrorMessage.AIRPLANE_WITH_SUCH_ID_DOES_NOT_EXISTS);
        }
    }

    @Override
    public Airplane reassignToAnotherAirCompany(String airplaneName, String airCompanyName) {

        Airplane airplane = getByName(airplaneName);
        AirCompany airCompany = airCompanyService.getAirCompanyByName(airCompanyName);

        airplane.setAirCompany(airCompany);
        return airplane;
    }

    private void setAirplaneType(String type, Airplane airplane) {

        if(!type.toLowerCase().equals(EnumString.PASSENGER)
                && !type.toLowerCase().equals(EnumString.CARGO)) {

            throw new IncorrectTypeException(ErrorMessage.INCORRECT_AIRPLANE_TYPE);
        }
        if(type.toLowerCase().equals(EnumString.PASSENGER)) {
            airplane.setType(AirplaneType.PASSENGER);
        }
        if(type.toLowerCase().equals(EnumString.CARGO)) {
            airplane.setType(AirplaneType.CARGO);
        }
    }

    private Airplane mapDtoToEntity(Airplane airplane, AirplaneDto airplaneDto) {

        airplane.setName(airplaneDto.getName());
        airplane.setSerialNumber(airplaneDto.getSerialNumber());

        if(airplaneDto.getAirCompanyName() != null) {
            airplane.setAirCompany(airCompanyService.getAirCompanyByName(airplaneDto.getAirCompanyName()));
        }

        setAirplaneType(airplaneDto.getType(), airplane);
        airplane.setFlightDistance(airplaneDto.getFlightDistance());
        airplane.setNumberOfFlights(airplaneDto.getNumberOfFlights());
        airplane.setFuelCapacity(airplaneDto.getFuelCapacity());
        airplane.setCreatedAt(airplaneDto.getCreatedAt());

        return airplane;
    }
}
