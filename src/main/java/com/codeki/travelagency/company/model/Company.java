package com.codeki.travelagency.company.model;

import jakarta.persistence.*;

@Entity
@Table(name="company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String page;
    private String banner;


    // -----------  COMPLETE CONSTRUCTOR  ------------
    public Company(Long id, String name, String page, String banner) {
        this.id = id;
        this.name = name;
        this.page = page;
        this.banner = banner;
    }

    // ----------  CONSTRUCTOR WITHOUT ID  -----------
    public Company(String name, String page, String banner) {
        this.name = name;
        this.page = page;
        this.banner = banner;
    }

    // -------------  CONSTRUCTOR EMPTY  -------------
    public Company() {
    }

    // ---------  GETTER AND SETTER METHODS  ---------
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

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }
}