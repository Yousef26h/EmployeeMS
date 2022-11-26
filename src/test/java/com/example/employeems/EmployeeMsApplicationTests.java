package com.example.employeems;

import com.example.employeems.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = EmployeeMsApplication.class)
@SpringBootTest
@AutoConfigureMockMvc

class EmployeeMsApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllEmployees() throws Exception {

        String json = "{\"name\": \"Fakhri Salem\", \"email\": \"fakhri_salem@gmail.com\"}";

        this.mockMvc.perform(
                post("/employers")
                .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
        ).andExpect(status().isCreated());
    }


}
