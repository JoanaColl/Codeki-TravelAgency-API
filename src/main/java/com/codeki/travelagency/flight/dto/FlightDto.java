package com.codeki.travelagency.flight.dto;

import com.codeki.travelagency.company.model.Company;

public class FlightDto {
    private Long id;
    private String origin;
    private String destiny;
    private String departureTime;
    private String arrivingTime;
    private double convertedPrice;
    private String frequency;
    private Company company;


    // -----------  COMPLETE CONSTRUCTOR  ------------
    public FlightDto(Long id, String origin, String destiny, String departureTime, String arrivingTime, double convertedPrice, String frequency, Company company) {
        this.id = id;
        this.origin = origin;
        this.destiny = destiny;
        this.departureTime = departureTime;
        this.arrivingTime = arrivingTime;
        this.convertedPrice = convertedPrice;
        this.frequency = frequency;
        this.company = company;
    }

    // ----------  CONSTRUCTOR WITHOUT ID  -----------
    public FlightDto(String origin, String destiny, String departureTime, String arrivingTime, double convertedPrice, String frequency, Company company) {
        this.origin = origin;
        this.destiny = destiny;
        this.departureTime = departureTime;
        this.arrivingTime = arrivingTime;
        this.convertedPrice = convertedPrice;
        this.frequency = frequency;
        this.company = company;
    }

    // -------------  CONSTRUCTOR EMPTY  -------------
    public FlightDto() {
    }


    // ---------  GETTER AND SETTER METHODS  ---------
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivingTime() {
        return arrivingTime;
    }

    public void setArrivingTime(String arrivingTime) {
        this.arrivingTime = arrivingTime;
    }

    public double getConvertedPrice() {
        return convertedPrice;
    }

    public void setConvertedPrice(double convertedPrice) {
        this.convertedPrice = convertedPrice;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}