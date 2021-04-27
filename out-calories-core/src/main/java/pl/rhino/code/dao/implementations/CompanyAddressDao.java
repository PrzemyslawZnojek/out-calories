package pl.rhino.code.dao.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import pl.rhino.code.dao.interfaces.ICompanyAddressDao;
import pl.rhino.code.model.CompanyAddress;

import javax.persistence.EntityManager;

public class CompanyAddressDao implements ICompanyAddressDao {

    private EntityManager entityManager;

    @Autowired
    public CompanyAddressDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public CompanyAddress findById(Long id) {
        return entityManager.find(CompanyAddress.class, id);
    }

    @Override
    public void createCompanyAddress(CompanyAddress companyAddress) {
        entityManager.persist(companyAddress);
    }
}
