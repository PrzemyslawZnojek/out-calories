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
import pl.rhino.code.dao.implementations.CompanyAddressDao;
import pl.rhino.code.model.CompanyAddress;
import pl.rhino.code.model.util.Country;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@Testcontainers
@SpringBootTest(classes = OutCaloriesCoreApplication.class)
public class CompanyAddressDaoTest {

    @Container
    public static PostgreSQLContainer<OutCaloriesPostgresqlContainer> postgreSQLContainer = OutCaloriesPostgresqlContainer.getInstance();

    @Autowired
    private CompanyAddressDao companyAddressDao;

    @BeforeAll
    static void init() {
        postgreSQLContainer.start();
    }

    @Test
    @Transactional
    void findByIdShouldEndWithSuccess() {
        CompanyAddress byId = companyAddressDao.findById(1L);
        assertEquals(1L, byId.getId());
    }

    @Test
    @Transactional
    void findAllTest() {
        List<CompanyAddress> companyAddresses = companyAddressDao.findAll();
        assertEquals(1, companyAddresses.size());
    }

    @Test
    @Transactional
    void insertCompanyAddress() {
        CompanyAddress newCompanyAddress = CompanyAddress.builder()
                .city("Cracow")
                .street("Starowislna")
                .country(Country.POLAND)
                .zipCode("30-000")
                .apartment("40")
                .build();

        companyAddressDao.createCompanyAddress(newCompanyAddress);
    }
}
