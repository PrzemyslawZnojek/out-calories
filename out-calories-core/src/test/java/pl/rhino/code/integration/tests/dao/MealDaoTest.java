package pl.rhino.code.integration.tests.dao;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import pl.rhino.code.OutCaloriesCoreApplication;
import pl.rhino.code.dao.implementations.MealDao;
import pl.rhino.code.model.Meal;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@Testcontainers
@SpringBootTest(classes = OutCaloriesCoreApplication.class)
public class MealDaoTest {

    @Container
    public static PostgreSQLContainer<OutCaloriesPostgresqlContainer> postgreSQLContainer = OutCaloriesPostgresqlContainer.getInstance();

    @Autowired
    private MealDao mealDao;

    @BeforeAll
    static void init() {
        postgreSQLContainer.start();
    }

    @Test
    @Transactional
    void findByIdShouldEndWithSuccess() {
        Meal byId = mealDao.findById(1L);
        assertEquals(1L, byId.getId());
    }

    @Test
    @Transactional
    void findAllTest() {
        List<Meal> meals = mealDao.findAll();
        assertEquals(1, meals.size());
    }

    @Test
    @Transactional
    void createCompanyEndWithSuccess() {
        Meal meal = Meal.builder()
                .name("Meal1")
                .prize(100D)
                .build();
        mealDao.createMeal(meal);
    }
}
