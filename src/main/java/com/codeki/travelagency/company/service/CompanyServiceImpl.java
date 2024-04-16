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
    public Company findCompanyById(Long id) throws ResourceNotFoundException {
        return companyRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("ID not found!"));
    }

    @Override
    public Company updateCompany(Long id, Company company) throws ResourceNotFoundException {
        if(!companyRepository.existsById(id)) {
            throw new ResourceNotFoundException("ID not found!");
        }
        Company updatedCompany = modelMapper.map(company, Company.class);
        company.setId(id);
        return companyRepository.save(company);
    }

    @Override
    public void deleteCompanyById(Long id) throws ResourceNotFoundException {
        Company deletedCompany = companyRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("ID not found!"));
        companyRepository.deleteById(deletedCompany.getId());
    }
}