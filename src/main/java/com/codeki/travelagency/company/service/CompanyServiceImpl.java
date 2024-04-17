package com.codeki.travelagency.company.service;

import com.codeki.travelagency.company.model.Company;
import com.codeki.travelagency.company.repository.CompanyRepository;
import com.codeki.travelagency.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    // -----------  DEPENDENCY INJECTION  ------------
    CompanyRepository companyRepository;
    ModelMapper modelMapper = new ModelMapper();

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    // ------------------  METHODS  ------------------
    @Override
    public Company  createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public List<Company> findAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company findCompanyById(Long companyId) throws ResourceNotFoundException {
        return companyRepository.findById(companyId).orElseThrow(()-> new ResourceNotFoundException("Company ID not found!"));
    }

    @Override
    public Company updateCompany(Long companyId, Company company) throws ResourceNotFoundException {
        if(!companyRepository.existsById(companyId)) {
            throw new ResourceNotFoundException("Company ID not found!");
        }
        Company updatedCompany = modelMapper.map(company, Company.class);
        updatedCompany.setId(companyId);
        return companyRepository.save(updatedCompany);
    }

    @Override
    public void deleteCompanyById(Long companyId) throws ResourceNotFoundException {
        Company deletedCompany = companyRepository.findById(companyId).orElseThrow(()-> new ResourceNotFoundException("Company ID not found!"));
        companyRepository.deleteById(deletedCompany.getId());
    }
}