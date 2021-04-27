package pl.rhino.code.dao.interfaces;

import pl.rhino.code.model.CompanyAddress;

public interface ICompanyAddressDao {

    CompanyAddress findById(Long id);
    void createCompanyAddress(CompanyAddress companyAddress);
}
