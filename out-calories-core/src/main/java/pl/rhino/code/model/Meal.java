package pl.rhino.code.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Meal {
    private long id;
    private long companyId;
    private String name;
    private int kcalAmount;
    private int proteins;
    private int carbohydrates;
    private int fats;
}
