package com.demo.aircompany.exception;

import java.util.Objects;

public class AirCompanyAppException extends RuntimeException {
    private String message;

    public AirCompanyAppException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirCompanyAppException that = (AirCompanyAppException) o;
        return message.equals(that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }

    @Override
    public String toString() {
        return "AirCompanyAppException{" +
                "message='" + message + '\'' +
                '}';
    }
}
