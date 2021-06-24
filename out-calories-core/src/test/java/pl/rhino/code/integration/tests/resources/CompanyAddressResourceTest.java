package pl.rhino.code.integration.tests.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pl.rhino.code.model.Company;
import pl.rhino.code.model.CompanyAddress;
import pl.rhino.code.model.util.Country;
import pl.rhino.code.resource.CompanyAddressResource;
import pl.rhino.code.service.implementations.CompanyAddressService;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CompanyAddressResource.class)
public class CompanyAddressResourceTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private CompanyAddressService service;

    @Test
    void validRetrievingById() throws Exception {
        mockMvc.perform(get("/company-address/{id}", 1L)
        .contentType("application/json")).andExpect(status().isOk());

        verify(service, times(1)).findById(1L);
    }

    @Test
    void validFindAll() throws Exception {
        mockMvc.perform(get("/company-address/all", 1L)
                .contentType("application/json")).andExpect(status().isOk());

        verify(service, times(1)).findAll(1L);
    }

    @Test
    void validCreateCompanyAddress() throws Exception {
        CompanyAddress newCompanyAddress = CompanyAddress.builder()
                .country(Country.POLAND)
                .zipCode("00-000")
                .city("City")
                .street("Street")
                .apartment("1C")
                .build();

        mockMvc.perform(post("/company-address/create")
                .contentType("application/json")
                .content(mapper.writeValueAsString(newCompanyAddress))).andExpect(status().isOk());

        verify(service, times(1)).createCompanyAddress(newCompanyAddress);
    }

}
