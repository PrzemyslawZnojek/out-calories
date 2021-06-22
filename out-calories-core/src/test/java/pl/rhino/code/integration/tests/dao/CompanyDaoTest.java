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
import pl.rhino.code.dao.implementations.CompanyDao;
import pl.rhino.code.model.Company;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@Testcontainers
@SpringBootTest(classes = OutCaloriesCoreApplication.class)
public class CompanyDaoTest {

    @Container
    public static PostgreSQLContainer<OutCaloriesPostgresqlContainer> postgreSQLContainer = OutCaloriesPostgresqlContainer.getInstance().withInitScript("db-init-script.sql");

    @Autowired
    private CompanyDao companyDao;

    @BeforeAll
    static void init() {
        postgreSQLContainer.start();
    }

    @Test
    @Transactional
    void findByIdShouldEndWithSuccess() {
        Company byId = companyDao.findById(1L);
        assertEquals(byId.getId(), 1L);
    }
}
