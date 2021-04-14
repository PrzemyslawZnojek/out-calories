package pl.rhino.code.model;

import lombok.Data;
import pl.rhino.code.model.util.Country;

import javax.persistence.Entity;

@Entity
@Data
public class CompanyAddress {
    private long id;
    private long companyId;
    private Country country;
    private String zipCode;
    private String city;
    private String street;
    private String apartment;
}
