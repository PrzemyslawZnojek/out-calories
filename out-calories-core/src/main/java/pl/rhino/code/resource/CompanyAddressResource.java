package pl.rhino.code.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.rhino.code.model.CompanyAddress;
import pl.rhino.code.service.interfaces.ICompanyAddressService;

@RestController
@RequestMapping(path = "/company-address", produces = "application/json")
public class CompanyAddressResource {

    ICompanyAddressService service;

    @Autowired
    public CompanyAddressResource(ICompanyAddressService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public CompanyAddress findById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @PostMapping("create")
    public void createCompanyAddress(@RequestBody CompanyAddress companyAddress){
        service.createCompanyAddress(companyAddress);
    }
}
