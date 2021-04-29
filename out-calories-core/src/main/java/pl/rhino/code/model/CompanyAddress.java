package pl.rhino.code.model;

import pl.rhino.code.model.util.Country;

import javax.persistence.*;

@Entity
public class CompanyAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_address_generator")
    @SequenceGenerator(name = "company_address_generator", sequenceName = "company_address_id_seq")
    private long id;

    @ManyToOne
    @JoinColumn(name = "company_ID")
    private Company company;
    private Country country;
    private String zipCode;
    private String city;
    private String street;
    private String apartment;
}
