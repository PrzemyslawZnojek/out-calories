package pl.rhino.code.service.interfaces;

import pl.rhino.code.model.Company;

public interface ICompanyService {

    Company findById(Long id);
}
