package com.demo.aircompany.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DataNotFoundException extends AirCompanyAppException{

    public DataNotFoundException(String message) {
        super(message);
    }

}
