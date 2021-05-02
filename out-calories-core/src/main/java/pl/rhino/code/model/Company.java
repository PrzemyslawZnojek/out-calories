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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_id_generator")
    @SequenceGenerator(name = "company_id_generator", sequenceName = "company_id_seq")
    private long id;
    private String name;

    @OneToMany(mappedBy = "company")
    @JsonManagedReference
    private List<CompanyAddress> addresses;

    @OneToMany(mappedBy = "company")
    @JsonManagedReference
    private List<Meal> meals;

    public Company() {
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
