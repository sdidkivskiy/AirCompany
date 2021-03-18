package com.demo.aircompany.model.dto;

import java.time.LocalDateTime;

public class FlightDto {

    private String status;

    private String airCompanyName;

    private String airplaneName;

    private String departureCountryName;

    private String destinationCountryName;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAirCompanyName() {
        return airCompanyName;
    }

    public void setAirCompanyName(String airCompanyName) {
        this.airCompanyName = airCompanyName;
    }

    public String getAirplaneName() {
        return airplaneName;
    }

    public void setAirplaneName(String airplaneName) {
        this.airplaneName = airplaneName;
    }

    public String getDepartureCountryName() {
        return departureCountryName;
    }

    public void setDepartureCountryName(String departureCountryName) {
        this.departureCountryName = departureCountryName;
    }

    public String getDestinationCountryName() {
        return destinationCountryName;
    }

    public void setDestinationCountryName(String destinationCountryName) {
        this.destinationCountryName = destinationCountryName;
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
    public String toString() {
        return "FlightDto{" +
                "status='" + status + '\'' +
                ", airCompanyName='" + airCompanyName + '\'' +
                ", airplaneName='" + airplaneName + '\'' +
                ", departureCountryName='" + departureCountryName + '\'' +
                ", destinationCountryName='" + destinationCountryName + '\'' +
                ", distance=" + distance +
                ", estimatedTime='" + estimatedTime + '\'' +
                ", endedAt=" + endedAt +
                ", delayStartedAt=" + delayStartedAt +
                ", createdAt=" + createdAt +
                ", startedAt=" + startedAt +
                '}';
    }
}
