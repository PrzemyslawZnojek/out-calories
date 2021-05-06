package pl.rhino.code.integration.tests.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pl.rhino.code.resource.CompanyAddressResource;
import pl.rhino.code.service.implementations.CompanyAddressService;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CompanyAddressResource.class)
public class CompanyAddressResourceTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CompanyAddressService service;

    @Test
    void whenValidInputThenReturns200() throws Exception {
        mockMvc.perform(
                get("/company-address/1")
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void validRetrievingById() throws Exception {
        mockMvc.perform(get("/company-address/{id}", 1L)
        .contentType("application/json"));
        verify(service, times(1)).findById(1L);
    }

}
