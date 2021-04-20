package pl.rhino.code.dao.interfaces;

import org.springframework.stereotype.Repository;
import pl.rhino.code.model.Company;

public interface ICompanyDao {
    Company findById(Long id);
}
