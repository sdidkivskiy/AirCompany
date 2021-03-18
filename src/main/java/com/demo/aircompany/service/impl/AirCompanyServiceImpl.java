package com.demo.aircompany.service.impl;

import com.demo.aircompany.constant.EnumString;
import com.demo.aircompany.constant.ErrorMessage;
import com.demo.aircompany.exception.DataNotFoundException;
import com.demo.aircompany.exception.IncorrectTypeException;
import com.demo.aircompany.model.AirCompany;
import com.demo.aircompany.model.AirCompanyType;
import com.demo.aircompany.model.dto.AirCompanyDto;
import com.demo.aircompany.repository.AirCompanyRepository;
import com.demo.aircompany.service.AirCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirCompanyServiceImpl implements AirCompanyService {

    private final AirCompanyRepository airCompanyRepository;

    @Autowired
    public AirCompanyServiceImpl(AirCompanyRepository airCompanyRepository) {
        this.airCompanyRepository = airCompanyRepository;
    }

    @Override
    public AirCompany create(AirCompanyDto airCompanyDto) {

        AirCompany airCompany = new AirCompany();
        airCompany.setName(airCompanyDto.getName());
        airCompany.setFoundedAt(airCompanyDto.getFoundedAt());
        setAirCompanyType(airCompanyDto.getType(), airCompany);

        return airCompanyRepository.save(airCompany);
    }

    @Override
    public AirCompany getAirCompanyById(Long id) {
        return airCompanyRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(ErrorMessage.AIR_COMPANY_WITH_SUCH_ID_DOES_NOT_EXISTS));
    }

    @Override
    public AirCompany getAirCompanyByName(String name) {

        AirCompany airCompany = airCompanyRepository.findByName(name);

        if(airCompany != null) {
            return airCompany;
        } else {
            throw new DataNotFoundException(ErrorMessage.AIR_COMPANY_WITH_SUCH_NAME_DOES_NOT_EXISTS);
        }
    }

    @Override
    public AirCompany updateAirCompany(Long id, AirCompanyDto airCompanyDto) {

        AirCompany airCompany = new AirCompany();
        airCompany.setId(id);
        airCompany.setName(airCompanyDto.getName());
        setAirCompanyType(airCompanyDto.getType(), airCompany);
        airCompany.setFoundedAt(airCompanyDto.getFoundedAt());

        return airCompanyRepository.save(airCompany);
    }

    @Override
    public void deleteAirCompanyById(Long id) {

        if(airCompanyRepository.existsById(id)) {
            airCompanyRepository.delete(getAirCompanyById(id));
        } else {
            throw new DataNotFoundException(ErrorMessage.AIR_COMPANY_WITH_SUCH_ID_DOES_NOT_EXISTS);
        }
    }

    private void setAirCompanyType(String type, AirCompany airCompany) {
        if(!type.toLowerCase().equals(EnumString.UNIVERSE)
                && !type.toLowerCase().equals(EnumString.SPECIFIC)) {

            throw new IncorrectTypeException(ErrorMessage.INCORRECT_AIR_COMPANY_TYPE);
        }
        if(type.toLowerCase().equals(EnumString.UNIVERSE)) {
            airCompany.setType(AirCompanyType.UNIVERSE);
        }
        if(type.toLowerCase().equals(EnumString.SPECIFIC)) {
            airCompany.setType(AirCompanyType.SPECIFIC);
        }
    }

}
