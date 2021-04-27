package pl.rhino.code.service.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import pl.rhino.code.dao.interfaces.ICompanyAddressDao;
import pl.rhino.code.model.CompanyAddress;

public interface ICompanyAddressService {

    CompanyAddress findById(Long id);
    void createCompanyAddress(CompanyAddress companyAddress);
}
