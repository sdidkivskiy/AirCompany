package com.demo.aircompany.model.dto;

import java.time.LocalDate;

public class AirCompanyDto {

    private String name;

    private String type;

    private LocalDate foundedAt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getFoundedAt() {
        return foundedAt;
    }

    public void setFoundedAt(LocalDate foundedAt) {
        this.foundedAt = foundedAt;
    }

    @Override
    public String toString() {
        return "AirCompanyDto{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", foundedAt=" + foundedAt +
                '}';
    }
}
