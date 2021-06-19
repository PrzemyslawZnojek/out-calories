package pl.rhino.code.integration.tests.dao;

import org.junit.ClassRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;
import pl.rhino.code.OutCaloriesCoreApplication;
import pl.rhino.code.dao.implementations.CompanyAddressDao;
import pl.rhino.code.model.CompanyAddress;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = OutCaloriesCoreApplication.class)
@ActiveProfiles({"tc", "tc-auto"})
public class CompanyAddressDaoTest {

    @ClassRule
    public static PostgreSQLContainer<OutCaloriesPostgresqlContainer> postgreSQLContainer = OutCaloriesPostgresqlContainer.getInstance();

    @Autowired
    private CompanyAddressDao companyAddressDao;

    @BeforeAll
    static void init(){
        postgreSQLContainer.start();
    }

    @Test
   // @Transactional
    void findByIdShouldEndWithSuccess() {
        //insertCompanyAddress();
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
