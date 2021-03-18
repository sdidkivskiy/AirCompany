package com.demo.aircompany.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class IncorrectTypeException extends AirCompanyAppException {

    public IncorrectTypeException(String message) {
        super(message);
    }
}
