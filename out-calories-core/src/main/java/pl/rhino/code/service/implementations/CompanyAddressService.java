package pl.rhino.code.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.rhino.code.dao.interfaces.ICompanyAddressDao;
import pl.rhino.code.model.CompanyAddress;
import pl.rhino.code.service.interfaces.ICompanyAddressService;

import java.util.List;

@Service
public class CompanyAddressService implements ICompanyAddressService {

    ICompanyAddressDao companyAddressDao;

    @Autowired
    public CompanyAddressService(ICompanyAddressDao companyAddressDao) {
        this.companyAddressDao = companyAddressDao;
    }

    @Override
    @Transactional
    public CompanyAddress findById(Long id) {
        return companyAddressDao.findById(id);
    }

    @Override
    @Transactional
    public List<CompanyAddress> findAll() {
        return companyAddressDao.findAll();
    }

    @Override
    @Transactional
    public void createCompanyAddress(CompanyAddress companyAddress) {
        companyAddressDao.createCompanyAddress(companyAddress);
    }
}
