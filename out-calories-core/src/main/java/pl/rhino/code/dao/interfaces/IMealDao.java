package pl.rhino.code.dao.interfaces;

import pl.rhino.code.model.Meal;

import java.util.List;

public interface IMealDao {
    Meal findById(Long id);
    List<Meal> findAll();
    void createMeal(Meal meal);
}
