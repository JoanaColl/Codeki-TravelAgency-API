package com.codeki.travelagency.repository;

import com.codeki.travelagency.company.model.Company;
import com.codeki.travelagency.company.repository.CompanyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CompanyRepositoryTest {
    @Autowired
    private CompanyRepository companyRepository;
    private Company company;

    @BeforeEach
    void setup() {
        company = new Company("Flybondi", "flybondi.com", "Logo Flybondi");
    }

    @Test
    void saveTest() {
        Company savedCompany = companyRepository.save(company);

        assertThat(savedCompany).isNotNull();
        assertThat("Flybondi").isEqualTo(savedCompany.getName());
    }

    @Test
    void findAllTest() {
        Company company2 = new Company("Aerolineas Argentinas", "aerolineasargentinas.com.ar", "Logo Aerolineas Argentinas");

        companyRepository.save(company);
        companyRepository.save(company2);

        List<Company> listCompanies = companyRepository.findAll();

        assertThat(listCompanies).isNotNull();
        assertThat(listCompanies.size()).isEqualTo(2);
    }

    @Test
    void findByIdTest() {
        Company savedCompany = companyRepository.save(company);

        Company findedCompany = companyRepository.findById(savedCompany.getId()).get();

        assertThat(findedCompany).isNotNull();
    }

    @Test
    void updateTest() {
        Company savedCompany = companyRepository.save(company);
        Company findedCompany = companyRepository.findById(savedCompany.getId()).get();

        findedCompany.setName("JetSMART");
        findedCompany.setPage("jetsmart.com.ar");
        findedCompany.setBanner("Logo JetSMART");

        Company updatedCompany = companyRepository.save(findedCompany);

        assertThat(updatedCompany.getName()).isEqualTo("JetSMART");
        assertThat(updatedCompany.getPage()).isEqualTo("jetsmart.com.ar");
        assertThat(updatedCompany.getBanner()).isEqualTo("Logo JetSMART");
    }

    @Test
    void deleteByIdTest() {
        Company savedCompany = companyRepository.save(company);
        companyRepository.deleteById(savedCompany.getId());

        Optional<Company> findedCompany = companyRepository.findById(savedCompany.getId());

        assertThat(findedCompany).isEmpty();
    }
}