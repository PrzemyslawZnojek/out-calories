package pl.rhino.code.dao.interfaces;

import pl.rhino.code.model.Meal;

public interface IMealDao {
    Meal findById(Long id);
    void createMeal(Meal meal);
}
