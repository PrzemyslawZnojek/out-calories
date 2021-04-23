package pl.rhino.code.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.rhino.code.dao.interfaces.ICompanyDao;
import pl.rhino.code.model.Company;
import pl.rhino.code.service.interfaces.ICompanyService;

@Service
public class CompanyService implements ICompanyService {

    @Autowired
    ICompanyDao companyDao;

    @Override
    @Transactional
    public Company findById(Long id) {
        return companyDao.findById(id);
    }

    @Override
    @Transactional
    public void createCompany(Company company){
        companyDao.createCompany(company);
    }


}
