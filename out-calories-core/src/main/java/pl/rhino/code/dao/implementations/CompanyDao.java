package pl.rhino.code.dao.implementations;

import org.hibernate.Session;
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
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Company.class, id);
    }
}
