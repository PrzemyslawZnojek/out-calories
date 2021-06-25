package pl.rhino.code.service.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import pl.rhino.code.dao.interfaces.ICompanyAddressDao;
import pl.rhino.code.model.CompanyAddress;

import java.util.List;

public interface ICompanyAddressService {

    CompanyAddress findById(Long id);
    List<CompanyAddress> findAll();
    void createCompanyAddress(CompanyAddress companyAddress);
}
