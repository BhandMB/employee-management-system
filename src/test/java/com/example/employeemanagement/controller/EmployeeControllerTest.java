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
    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    private MockMvc mockMvc;
    private Employee testEmployee;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();

        testEmployee = new Employee();
        testEmployee.setId(1L);
        testEmployee.setName("John Doe");
        testEmployee.setDepartment("Engineering");
        testEmployee.setEmail("john.doe@example.com");
        testEmployee.setSalary(50000.0);
    }

    @Test
    void testGetAllEmployees() throws Exception {
        List<Employee> employees = new ArrayList<>();
        employees.add(testEmployee);

        Employee employee2 = new Employee();
        employee2.setId(2L);
        employee2.setName("Jane Smith");
        employee2.setDepartment("Sales");
        employee2.setEmail("jane.smith@example.com");
        employee2.setSalary(60000.0);
        employees.add(employee2);

        when(employeeService.getAllEmployees()).thenReturn(employees);

        mockMvc.perform(get("/employees").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name").value("John Doe"))
                .andExpect(jsonPath("$[1].name").value("Jane Smith"));

        verify(employeeService, times(1)).getAllEmployees();
    }

    @Test
    void testGetAllEmployeesEmpty() throws Exception {
        when(employeeService.getAllEmployees()).thenReturn(new ArrayList<>());

        mockMvc.perform(get("/employees").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));

        verify(employeeService, times(1)).getAllEmployees();
    }

    @Test
    void testAddEmployee() throws Exception {
        when(employeeService.addEmployee(any(Employee.class))).thenReturn(testEmployee);

        String employeeJson = "{\"name\":\"John Doe\",\"department\":\"Engineering\",\"email\":\"john.doe@example.com\",\"salary\":50000.0}";
        mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(employeeJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.department").value("Engineering"))
                .andExpect(jsonPath("$.email").value("john.doe@example.com"))
                .andExpect(jsonPath("$.salary").value(50000.0));

        verify(employeeService, times(1)).addEmployee(any(Employee.class));
    }

    @Test
    void testAddEmployeeWithValidData() throws Exception {
        Employee savedEmployee = new Employee();
        savedEmployee.setId(3L);
        savedEmployee.setName("Alice Johnson");
        savedEmployee.setDepartment("Marketing");
        savedEmployee.setEmail("alice@example.com");
        savedEmployee.setSalary(55000.0);

        when(employeeService.addEmployee(any(Employee.class))).thenReturn(savedEmployee);

        String employeeJson = "{\"name\":\"Alice Johnson\",\"department\":\"Marketing\",\"email\":\"alice@example.com\",\"salary\":55000.0}";
        mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(employeeJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(3))
                .andExpect(jsonPath("$.name").value("Alice Johnson"));

        verify(employeeService, times(1)).addEmployee(any(Employee.class));
    }

    @Test
    void testDeleteEmployee() throws Exception {
        Long employeeId = 1L;
        doNothing().when(employeeService).deleteEmployee(employeeId);

        mockMvc.perform(delete("/employees/{id}", employeeId).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(employeeService, times(1)).deleteEmployee(employeeId);
    }

    @Test
    void testDeleteNonExistentEmployee() throws Exception {
        Long employeeId = 999L;
        doNothing().when(employeeService).deleteEmployee(employeeId);

        mockMvc.perform(delete("/employees/{id}", employeeId).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(employeeService, times(1)).deleteEmployee(employeeId);
    }

    @Test
    void testControllerConstructor() {
        assert employeeController != null;
    }

    @Test
    void testGetAllEmployeesWithMultipleRecords() throws Exception {
        List<Employee> employees = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Employee emp = new Employee();
            emp.setId((long) i);
            emp.setName("Employee " + i);
            emp.setDepartment("Dept " + i);
            emp.setEmail("emp" + i + "@example.com");
            emp.setSalary(40000.0 + (i * 5000));
            employees.add(emp);
        }

        when(employeeService.getAllEmployees()).thenReturn(employees);

        mockMvc.perform(get("/employees").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(5)))
                .andExpect(jsonPath("$[0].name").value("Employee 1"))
                .andExpect(jsonPath("$[4].name").value("Employee 5"));

        verify(employeeService, times(1)).getAllEmployees();
    }
}
