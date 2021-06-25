package pl.rhino.code.dao.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.rhino.code.dao.interfaces.IMealDao;
import pl.rhino.code.model.Meal;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class MealDao implements IMealDao {

    @Autowired
    EntityManager entityManager;


    @Override
    public Meal findById(Long id) {
        return entityManager.find(Meal.class, id);
    }

    @Override
    public List<Meal> findAll() {
        return entityManager.createQuery("SELECT m FROM Meal m", Meal.class).getResultList();
    }

    @Override
    public void createMeal(Meal meal) {
        entityManager.persist(meal);
    }
}
