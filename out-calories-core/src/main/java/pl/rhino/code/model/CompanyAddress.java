package pl.rhino.code.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.rhino.code.model.util.Country;

import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity
@Data @Builder @NoArgsConstructor
public class CompanyAddress {

    //@Id
    private long id;
    private long companyId;
    private Country country;
    private String zipCode;
    private String city;
    private String street;
    private String apartment;
}
