package pl.rhino.code.service.interfaces;

import pl.rhino.code.model.Meal;

public interface IMealService {

    Meal findById(Long id);
}
