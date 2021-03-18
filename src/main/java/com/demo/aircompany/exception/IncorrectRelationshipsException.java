package com.demo.aircompany.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class IncorrectRelationshipsException extends AirCompanyAppException{

    public IncorrectRelationshipsException(String message) {
        super(message);
    }
}
