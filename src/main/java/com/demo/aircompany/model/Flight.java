package com.demo.aircompany.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private FlightStatus status;

    @ManyToOne
    private AirCompany airCompany;

    @OneToOne
    private Airplane airplane;

    @ManyToOne
    private Country departureCountry;

    @ManyToOne
    private Country destinationCountry;

    private Double distance;

    private String estimatedTime;

    private LocalDateTime endedAt;

    private LocalDateTime delayStartedAt;

    private LocalDateTime createdAt;

    private LocalDateTime startedAt;

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public Flight() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

    public AirCompany getAirCompany() {
        return airCompany;
    }

    public void setAirCompany(AirCompany airCompany) {
        this.airCompany = airCompany;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Country getDepartureCountry() {
        return departureCountry;
    }

    public void setDepartureCountry(Country departureCountry) {
        this.departureCountry = departureCountry;
    }

    public Country getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(Country destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(String estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public LocalDateTime getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(LocalDateTime endedAt) {
        this.endedAt = endedAt;
    }

    public LocalDateTime getDelayStartedAt() {
        return delayStartedAt;
    }

    public void setDelayStartedAt(LocalDateTime delayStartedAt) {
        this.delayStartedAt = delayStartedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(id, flight.id) && status == flight.status && Objects.equals(airCompany, flight.airCompany) && Objects.equals(airplane, flight.airplane) && Objects.equals(departureCountry, flight.departureCountry) && Objects.equals(destinationCountry, flight.destinationCountry) && Objects.equals(distance, flight.distance) && Objects.equals(estimatedTime, flight.estimatedTime) && Objects.equals(endedAt, flight.endedAt) && Objects.equals(delayStartedAt, flight.delayStartedAt) && Objects.equals(createdAt, flight.createdAt) && Objects.equals(startedAt, flight.startedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, airCompany, airplane, departureCountry, destinationCountry, distance, estimatedTime, endedAt, delayStartedAt, createdAt, startedAt);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", status=" + status +
                ", airCompany=" + airCompany +
                ", airplane=" + airplane +
                ", departureCountry=" + departureCountry +
                ", destinationCountry=" + destinationCountry +
                ", distance=" + distance +
                ", estimatedTime='" + estimatedTime + '\'' +
                ", endedAt=" + endedAt +
                ", delayStartedAt=" + delayStartedAt +
                ", createdAt=" + createdAt +
                ", startedAt=" + startedAt +
                '}';
    }
}
