package pl.rhino.code.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import pl.rhino.code.dao.interfaces.ICompanyAddressDao;
import pl.rhino.code.model.CompanyAddress;
import pl.rhino.code.service.interfaces.ICompanyAddressService;

public class CompanyAddressService implements ICompanyAddressService {

    ICompanyAddressDao companyAddressDao;

    @Autowired
    public CompanyAddressService(ICompanyAddressDao companyAddressDao) {
        this.companyAddressDao = companyAddressDao;
    }

    @Override
    public CompanyAddress findById(Long id) {
        return companyAddressDao.findById(id);
    }

    @Override
    public void createCompanyAddress(CompanyAddress companyAddress) {
        companyAddressDao.createCompanyAddress(companyAddress);
    }
}
