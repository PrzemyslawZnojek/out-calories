package pl.rhino.code.service.interfaces;

import pl.rhino.code.model.Company;

import java.util.List;

public interface ICompanyService {

    Company findById(Long id);
    List<Company> findAll();
    void createCompany(Company company);
}
