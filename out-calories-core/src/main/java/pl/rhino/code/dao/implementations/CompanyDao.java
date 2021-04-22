package pl.rhino.code.dao.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.rhino.code.dao.interfaces.ICompanyDao;
import pl.rhino.code.model.Company;

import javax.persistence.EntityManager;

@Repository
public class CompanyDao implements ICompanyDao {

    private EntityManager entityManager;

    @Autowired
    public CompanyDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Company findById(Long id) {
        return entityManager.find(Company.class, id);
    }

    @Override
    public void createCompany(Company company) {

    }


}
