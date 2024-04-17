package com.codeki.travelagency.flight.model;

import com.codeki.travelagency.company.model.Company;
import jakarta.persistence.*;

@Entity
@Table(name="flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String origin;
    private String destiny;
    private String departureTime;
    private String arrivingTime;
    private double price;
    private String frequency;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;


    // -----------  COMPLETE CONSTRUCTOR  ------------
    public Flight(Long id, String origin, String destiny, String departureTime, String arrivingTime, double price, String frequency) {
        this.id = id;
        this.origin = origin;
        this.destiny = destiny;
        this.departureTime = departureTime;
        this.arrivingTime = arrivingTime;
        this.price = price;
        this.frequency = frequency;
    }

    // ----------  CONSTRUCTOR WITHOUT ID  -----------
    public Flight(String origin, String destiny, String departureTime, String arrivingTime, double price, String frequency) {
        this.origin = origin;
        this.destiny = destiny;
        this.departureTime = departureTime;
        this.arrivingTime = arrivingTime;
        this.price = price;
        this.frequency = frequency;
    }

    // -------------  CONSTRUCTOR EMPTY  -------------
    public Flight() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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