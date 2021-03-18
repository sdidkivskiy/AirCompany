package com.demo.aircompany.constant;

public class ErrorMessage {

    //AirCompany
    public static final String AIR_COMPANY_WITH_SUCH_ID_DOES_NOT_EXISTS = "AirCompany with such id does not exists!";
    public static final String AIR_COMPANY_WITH_SUCH_NAME_DOES_NOT_EXISTS = "AirCompany with such name does not exists!";
    public static final String INCORRECT_AIR_COMPANY_TYPE = "Incorrect AirCompany type(must be universe or specific)";

    //Airplane
    public static final String AIRPLANE_WITH_SUCH_ID_DOES_NOT_EXISTS = "Airplane with such id does not exists!";
    public static final String AIRPLANE_WITH_SUCH_NAME_DOES_NOT_EXISTS = "Airplane with such name does not exists!";
    public static final String INCORRECT_AIRPLANE_TYPE = "Incorrect Airplane type(must be universe or cargo)";

    //Country
    public static final String COUNTRY_WITH_SUCH_ID_DOES_NOT_EXISTS = "Country with such id does not exists!";
    public static final String COUNTRY_WITH_SUCH_NAME_DOES_NOT_EXISTS = "Country with such name does not exists!";

    //Flight
    public static final String FLIGHT_WITH_SUCH_ID_DOES_NOT_EXISTS = "Flight with such id does not exists!";
    public static final String INCORRECT_FLIGHT_STATUS = "Incorrect Flight status(must be ACTIVE, DELAYED, PENDING, COMPLETED)";

}
