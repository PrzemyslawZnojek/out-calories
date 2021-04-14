package pl.rhino.code.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Company {
    private long id;
    private String companyName;
    private CompanyAddress address;
}
