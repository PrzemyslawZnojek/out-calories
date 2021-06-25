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

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@Testcontainers
@SpringBootTest(classes = OutCaloriesCoreApplication.class)
public class CompanyDaoTest {

    @Container
    public static PostgreSQLContainer<OutCaloriesPostgresqlContainer> postgreSQLContainer = OutCaloriesPostgresqlContainer.getInstance();

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
        assertEquals(1L, byId.getId());
    }

    @Test
    @Transactional
    void findAllTest() {
        List<Company> companies = companyDao.findAll();
        assertEquals(1, companies.size());
    }

    @Test
    @Transactional
    void createCompanyEndWithSuccess() {
        Company company = Company.builder()
                .name("Company2")
                .build();
        companyDao.createCompany(company);
    }
}
