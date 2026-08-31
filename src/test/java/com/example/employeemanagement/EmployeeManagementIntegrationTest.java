package com.example.employeemanagement;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeManagementIntegrationTest {
    @Autowired MockMvc mvc;
    @Autowired EmployeeRepository repository;

    @Test @WithMockUser(roles="ADMIN")
    void createSearchUpdateAndDeleteEmployee() throws Exception {
        repository.deleteAll();
        String json="{\"name\":\"Integration User\",\"department\":\"Engineering\",\"email\":\"integration@example.com\",\"salary\":70000}";
        mvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isOk()).andExpect(jsonPath("$.name").value("Integration User"));
        mvc.perform(get("/employees?search=Integration&size=10")).andExpect(status().isOk()).andExpect(jsonPath("$.content",hasSize(1)));
        Employee e=repository.findAll().get(0);
        mvc.perform(put("/employees/"+e.getId()).contentType(MediaType.APPLICATION_JSON).content("{\"name\":\"Updated User\",\"department\":\"HR\",\"email\":\"updated@example.com\",\"salary\":80000,\"active\":false}"))
                .andExpect(status().isOk()).andExpect(jsonPath("$.name").value("Updated User")).andExpect(jsonPath("$.active").value(false));
        mvc.perform(delete("/employees/"+e.getId())).andExpect(status().isNoContent());
    }

    @Test @WithMockUser(roles="EMPLOYEE")
    void employeeRoleCannotCreateOrDelete() throws Exception {
        mvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON).content("{\"name\":\"X\",\"department\":\"IT\",\"email\":\"x@example.com\",\"salary\":1}"))
                .andExpect(status().isForbidden());
        mvc.perform(delete("/employees/999")).andExpect(status().isForbidden());
    }
}
