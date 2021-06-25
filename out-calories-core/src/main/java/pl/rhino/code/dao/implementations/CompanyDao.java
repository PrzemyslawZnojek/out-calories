package pl.rhino.code.dao.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.rhino.code.dao.interfaces.ICompanyDao;
import pl.rhino.code.model.Company;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CompanyDao implements ICompanyDao {

    private EntityManager entityManager;

    @Autowired
    public CompanyDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Company findById(Long id) {
        return entityManager.find(Company.class, id);
    }

    @Override
    @Transactional
    public List<Company> findAll() {
        return entityManager.createQuery("SELECT c FROM Company c", Company.class).getResultList();
    }

    @Override
    @Transactional
    public void createCompany(Company company) {
        entityManager.persist(company);
    }
}
