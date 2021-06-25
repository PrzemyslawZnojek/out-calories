package pl.rhino.code.service.interfaces;

import pl.rhino.code.model.Meal;

import java.util.List;

public interface IMealService {

    Meal findById(Long id);
    List<Meal> findAll();
    void createMeal(Meal meal);
}
