package pl.rhino.code.integration.tests.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pl.rhino.code.model.Meal;
import pl.rhino.code.model.util.Currency;
import pl.rhino.code.resource.MealResource;
import pl.rhino.code.service.implementations.MealService;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@WebMvcTest(controllers = MealResource.class)
public class MealResourceTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private MealService service;

    @Test
    void validRetrievingById() throws Exception {
        mockMvc.perform(get("/meal/{id}", 1L)
                .contentType("application/json"));
        verify(service, times(1)).findById(1L);
    }

    @Test
    void validCreateMeal() throws Exception {
        Meal newMeal = Meal.builder()
                .name("dinner")
                .kcalAmount(750)
                .fats(15)
                .carbohydrates(100)
                .proteins(60)
                .prize(16.5)
                .currency(Currency.PLN)
                .build();

        mockMvc.perform(post("/meal/create")
                .contentType("application/json")
                .content(mapper.writeValueAsString(newMeal)));

        verify(service, times(1)).createMeal(newMeal);
    }

}
