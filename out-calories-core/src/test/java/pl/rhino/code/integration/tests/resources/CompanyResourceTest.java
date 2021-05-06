package pl.rhino.code.integration.tests.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pl.rhino.code.resource.CompanyResource;
import pl.rhino.code.service.implementations.CompanyService;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CompanyResource.class)
public class CompanyResourceTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CompanyService service;

    @Test
    void whenValidInputThenReturns200() throws Exception {
        mockMvc.perform(
                get("/company/1")
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
