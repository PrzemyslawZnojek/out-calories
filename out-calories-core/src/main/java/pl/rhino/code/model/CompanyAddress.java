package pl.rhino.code.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import pl.rhino.code.model.util.Country;

import javax.persistence.*;

@Entity
public class CompanyAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_address_id_generator")
    @SequenceGenerator(name = "company_address_id_generator", sequenceName = "company_address_id_seq")
    private long id;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID")
    @JsonBackReference
    private Company company;

    @Enumerated(EnumType.STRING)
    private Country country;
    private String zipCode;
    private String city;
    private String street;
    private String apartment;

    public CompanyAddress() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }
}

