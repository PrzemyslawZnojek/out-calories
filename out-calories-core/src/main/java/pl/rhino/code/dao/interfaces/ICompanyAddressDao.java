package pl.rhino.code.dao.interfaces;

import pl.rhino.code.model.CompanyAddress;

import java.util.List;

public interface ICompanyAddressDao {

    CompanyAddress findById(Long id);
    List<CompanyAddress> findAll();
    void createCompanyAddress(CompanyAddress companyAddress);
}
