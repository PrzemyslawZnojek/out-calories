package pl.rhino.code.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.rhino.code.model.Company;
import pl.rhino.code.service.interfaces.ICompanyService;

import java.util.List;

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

    @GetMapping("/all")
    public List<Company> findAll() { return service.findAll() ;}

    @PostMapping("create")
    public void createCompany(@RequestBody Company company){
        service.createCompany(company);
    }
}
