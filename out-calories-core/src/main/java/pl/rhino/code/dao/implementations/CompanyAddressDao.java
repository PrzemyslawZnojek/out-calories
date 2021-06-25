package pl.rhino.code.dao.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.rhino.code.dao.interfaces.ICompanyAddressDao;
import pl.rhino.code.model.CompanyAddress;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
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
    public List<CompanyAddress> findAll() {
        return entityManager.createQuery("SELECT ca FROM CompanyAddress ca", CompanyAddress.class).getResultList();
    }

    @Override
    public void createCompanyAddress(CompanyAddress companyAddress) {
        entityManager.persist(companyAddress);
    }
}
