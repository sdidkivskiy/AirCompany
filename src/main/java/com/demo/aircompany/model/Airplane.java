package com.demo.aircompany.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Airplane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String serialNumber;

    @ManyToOne
    private AirCompany airCompany;

    @ColumnDefault("0")
    private Integer numberOfFlights;

    @ColumnDefault("0")
    private Double flightDistance;

    @ColumnDefault("0")
    private Double fuelCapacity;

    @Enumerated(EnumType.STRING)
    private AirplaneType type;

    private LocalDate createdAt;

    public Airplane(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public AirCompany getAirCompany() {
        return airCompany;
    }

    public void setAirCompany(AirCompany airCompany) {
        this.airCompany = airCompany;
    }

    public Integer getNumberOfFlights() {
        return numberOfFlights;
    }

    public void setNumberOfFlights(Integer numberOfFlights) {
        this.numberOfFlights = numberOfFlights;
    }

    public Double getFlightDistance() {
        return flightDistance;
    }

    public void setFlightDistance(Double flightDistance) {
        this.flightDistance = flightDistance;
    }

    public Double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(Double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public AirplaneType getType() {
        return type;
    }

    public void setType(AirplaneType type) {
        this.type = type;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airplane airplane = (Airplane) o;
        return id.equals(airplane.id) && name.equals(airplane.name) && serialNumber.equals(airplane.serialNumber) && airCompany.equals(airplane.airCompany) && numberOfFlights.equals(airplane.numberOfFlights) && flightDistance.equals(airplane.flightDistance) && fuelCapacity.equals(airplane.fuelCapacity) && type == airplane.type && createdAt.equals(airplane.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, serialNumber, airCompany, numberOfFlights, flightDistance, fuelCapacity, type, createdAt);
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", airCompany=" + airCompany +
                ", numberOfFlights=" + numberOfFlights +
                ", flightDistance=" + flightDistance +
                ", fuelCapacity=" + fuelCapacity +
                ", type=" + type +
                ", createdAt=" + createdAt +
                '}';
    }
}
