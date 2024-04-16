package com.codeki.travelagency.company.service;

import com.codeki.travelagency.company.model.Company;
import java.util.List;

public interface CompanyService {
    Company  createCompany(Company company);
    List<Company> findAllCompanies();
    Company findCompanyById(Long id);
    Company updateCompany(Long id, Company company);
    void deleteCompanyById(Long id);
}