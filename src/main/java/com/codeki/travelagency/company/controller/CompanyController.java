package com.codeki.travelagency.company.controller;

import com.codeki.travelagency.company.model.Company;
import com.codeki.travelagency.company.service.CompanyService;
import com.codeki.travelagency.company.service.CompanyServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/travelagency/v1")
public class CompanyController {
    // -----------  DEPENDENCY INJECTION  ------------
    CompanyService companyService;

    public CompanyController(CompanyServiceImpl companyServiceImpl) {
        this.companyService = companyServiceImpl;
    }


    // -------------  CRUD METHODS  -------------
    @PostMapping("/company/create")
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        return new ResponseEntity<>(companyService.createCompany(company),HttpStatus.CREATED);
    }

    @GetMapping("/company")
    public ResponseEntity<List<Company>> findAllCompanies() {
        return new ResponseEntity<>(companyService.findAllCompanies(), HttpStatus.OK);
    }

    @GetMapping("/company/{id}")
    public ResponseEntity<Company> findCompanyById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(companyService.findCompanyById(id), HttpStatus.OK);
    }

    @PutMapping("/company/update")
    public ResponseEntity<Company> updateCompany(@RequestParam("id") Long id, @RequestBody Company company) {
        return new ResponseEntity<>(companyService.updateCompany(id, company), HttpStatus.OK);
    }

    @DeleteMapping("/company/delete/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable("id") Long id) {
        companyService.deleteCompanyById(id);
        return new ResponseEntity<>("Company deleted!", HttpStatus.OK);
    }
}