package integration.tests.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pl.rhino.code.resource.CompanyAddressResource;
import pl.rhino.code.service.implementations.CompanyAddressService;

@WebMvcTest(controllers = CompanyAddressResource.class)
public class CompanyAddressResourceTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CompanyAddressService service;
}
