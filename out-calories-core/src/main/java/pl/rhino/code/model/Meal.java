package pl.rhino.code.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.rhino.code.model.util.Currency;

import javax.persistence.*;

@Entity
@Data
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "meal_id_generator")
    @SequenceGenerator(name = "meal_id_generator", sequenceName = "meal_id_seq")
    private long id;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID")
    @JsonBackReference
    Company company;
    private String name;
    private int kcalAmount;
    private int proteins;
    private int carbohydrates;
    private int fats;
    private Double prize;

    @Enumerated(EnumType.STRING)
    private Currency currency;

}
