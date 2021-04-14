package pl.rhino.code.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class MealDao {

    @Autowired
    EntityManager entityManager;


}
