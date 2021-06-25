package pl.rhino.code.dao.interfaces;

import org.springframework.stereotype.Repository;
import pl.rhino.code.model.Company;

import java.util.List;

public interface ICompanyDao {
    Company findById(Long id);
    List<Company> findAll();
    void createCompany(Company company);
}
