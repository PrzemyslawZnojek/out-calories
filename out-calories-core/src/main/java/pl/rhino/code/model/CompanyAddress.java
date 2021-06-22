package pl.rhino.code.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.rhino.code.model.util.Country;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
}

