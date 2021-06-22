package pl.rhino.code.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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



}
