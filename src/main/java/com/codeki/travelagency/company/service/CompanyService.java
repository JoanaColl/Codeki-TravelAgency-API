package com.codeki.travelagency.company.service;

import com.codeki.travelagency.company.model.Company;
import java.util.List;

public interface CompanyService {
    Company  createCompany(Company company);
    List<Company> findAllCompanies();
    Company findCompanyById(Long companyId);
    Company updateCompany(Long companyId, Company company);
    void deleteCompanyById(Long companyId);
}