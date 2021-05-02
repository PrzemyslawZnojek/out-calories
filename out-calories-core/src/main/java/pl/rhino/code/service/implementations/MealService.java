package pl.rhino.code.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.rhino.code.dao.interfaces.IMealDao;
import pl.rhino.code.model.Meal;
import pl.rhino.code.service.interfaces.IMealService;

@Service
public class MealService implements IMealService {

    IMealDao mealDao;

    @Autowired
    public MealService(IMealDao mealDao) {
        this.mealDao = mealDao;
    }

    @Override
    public Meal findById(Long id) {
        return mealDao.findById(id);
    }
}
