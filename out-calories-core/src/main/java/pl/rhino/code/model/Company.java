package pl.rhino.code.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_generator")
    @SequenceGenerator(name = "company_generator", sequenceName = "company_id_seq")
    private long id;
    private String name;

    @OneToMany(mappedBy = "company")
    @JsonManagedReference
    private List<CompanyAddress> addresses;

    public Company() {
    }

    public Company(long id, String name, List<CompanyAddress> addresses) {
        this.id = id;
        this.name = name;
        this.addresses = addresses;
    }

    public Company(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CompanyAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<CompanyAddress> addresses) {
        this.addresses = addresses;
    }
}
