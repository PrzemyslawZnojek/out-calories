package pl.rhino.code.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.rhino.code.model.Company;
import pl.rhino.code.service.interfaces.ICompanyService;

@RestController
@RequestMapping(path = "/company", produces = "application/json")
public class CompanyResource {

    ICompanyService service;

    @Autowired
    public CompanyResource(ICompanyService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Company findById(@PathVariable("id") Long id){
        return service.findById(id);
    }
}
