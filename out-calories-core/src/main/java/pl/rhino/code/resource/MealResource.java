package pl.rhino.code.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.rhino.code.model.Meal;
import pl.rhino.code.service.interfaces.IMealService;

@RestController
@RequestMapping(path = "/meal", produces = "application/json")
public class MealResource {

    IMealService service;

    @Autowired
    public MealResource(IMealService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Meal findById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @PostMapping("/create")
    public void createMeal(@RequestBody Meal meal) {
        service.createMeal(meal);
    }
}
