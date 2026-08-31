package com.example.employeemanagement.controller;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {
    @Mock private EmployeeService employeeService;
    @InjectMocks private EmployeeController employeeController;
    private MockMvc mockMvc;
    private Employee testEmployee;

    @BeforeEach void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
        testEmployee = new Employee(); testEmployee.setId(1L); testEmployee.setName("John Doe");
        testEmployee.setDepartment("Engineering"); testEmployee.setEmail("john.doe@example.com"); testEmployee.setSalary(50000.0);
    }

    @Test void testGetAllEmployees() throws Exception {
        when(employeeService.getAllEmployees()).thenReturn(List.of(testEmployee));
        mockMvc.perform(get("/employees").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].name").value("John Doe"));
        verify(employeeService).getAllEmployees();
    }

    @Test void testGetAllEmployeesEmpty() throws Exception {
        when(employeeService.getAllEmployees()).thenReturn(new ArrayList<>());
        mockMvc.perform(get("/employees")).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(0)));
    }

    @Test void testAddEmployee() throws Exception {
        when(employeeService.addEmployee(any(Employee.class))).thenReturn(testEmployee);
        String json = "{\"name\":\"John Doe\",\"department\":\"Engineering\",\"email\":\"john.doe@example.com\",\"salary\":50000.0}";
        mockMvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isOk()).andExpect(jsonPath("$.name").value("John Doe"));
        verify(employeeService).addEmployee(any(Employee.class));
    }

    @Test void testDeleteEmployee() throws Exception {
        doNothing().when(employeeService).deleteEmployee(1L);
        mockMvc.perform(delete("/employees/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());
        verify(employeeService).deleteEmployee(1L);
    }

    @Test void testDashboardStats() throws Exception {
        when(employeeService.getTotalEmployees()).thenReturn(10L);
        when(employeeService.getActiveEmployees()).thenReturn(8L);
        when(employeeService.getDepartmentCount()).thenReturn(4L);
        when(employeeService.getTotalPayroll()).thenReturn(650000.0);
        mockMvc.perform(get("/employees/stats")).andExpect(status().isOk()).andExpect(jsonPath("$.totalEmployees").value(10)).andExpect(jsonPath("$.activeEmployees").value(8)).andExpect(jsonPath("$.departments").value(4)).andExpect(jsonPath("$.payroll").value(650000.0));
    }
}
