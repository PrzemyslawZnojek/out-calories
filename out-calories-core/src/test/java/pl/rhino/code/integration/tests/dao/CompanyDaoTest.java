package pl.rhino.code.integration.tests.dao;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;
import pl.rhino.code.OutCaloriesCoreApplication;
import pl.rhino.code.dao.implementations.CompanyDao;
import pl.rhino.code.model.Company;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OutCaloriesCoreApplication.class)
@ActiveProfiles({"tc", "tc-auto"})
public class CompanyDaoTest {
    @ClassRule
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
        insertCompany();
        Company company = companyDao.findById(1L);
        Assertions.assertNotNull(company);
    }

    void insertCompany() {
        Company company = Company.builder().id(1L).name("Company1").build();
        companyDao.createCompany(company);
    }
}
