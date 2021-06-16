package pl.rhino.code.integration.tests.dao;

import org.junit.ClassRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import pl.rhino.code.OutCaloriesCoreApplication;
import pl.rhino.code.dao.implementations.CompanyAddressDao;
import pl.rhino.code.dao.interfaces.ICompanyAddressDao;
import pl.rhino.code.model.CompanyAddress;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = {OutCaloriesCoreApplication.class, CompanyAddressDao.class})
public class CompanyAddressDaoTest {

    @Container
    PostgreSQLContainer container = (PostgreSQLContainer) new PostgreSQLContainer(
            "postgres:11.1")
            .withDatabaseName("out-calories")
            .withUsername("user")
            .withPassword("password")
            .withInitScript("db-init-script.sql");

    @Autowired
    private CompanyAddressDao companyAddressDao;

    @Test
    void findByIdShouldEndWithSuccess() {
        CompanyAddress companyAddress = companyAddressDao.findById(1L);
        Assertions.assertNotNull(companyAddress);
        assertThat(companyAddress.getCity()).isEqualTo("Cracow");
    }


    void insertCompanyAddress() {
        CompanyAddress newCompanyAddress = CompanyAddress.builder()
                .id(1L)
                .city("Cracow")
                .street("Starowislna")
                .zipCode("30-000")
                .apartment("40")

                .build();

        companyAddressDao.createCompanyAddress(newCompanyAddress);
    }
}
