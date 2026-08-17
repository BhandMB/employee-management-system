package com.example.employeemanagement.service;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    private Employee testEmployee;

    @BeforeEach
    void setUp() {
        testEmployee = new Employee();
        testEmployee.setId(1L);
        testEmployee.setName("John Doe");
        testEmployee.setDepartment("Engineering");
        testEmployee.setEmail("john.doe@example.com");
        testEmployee.setSalary(50000.0);
    }

    @Test
    void testGetAllEmployees() {
        List<Employee> expectedEmployees = new ArrayList<>();
        expectedEmployees.add(testEmployee);

        Employee employee2 = new Employee();
        employee2.setId(2L);
        employee2.setName("Jane Smith");
        employee2.setDepartment("Sales");
        employee2.setEmail("jane.smith@example.com");
        employee2.setSalary(60000.0);
        expectedEmployees.add(employee2);

        when(employeeRepository.findAll()).thenReturn(expectedEmployees);

        List<Employee> actualEmployees = employeeService.getAllEmployees();

        assertNotNull(actualEmployees);
        assertEquals(2, actualEmployees.size());
        assertEquals("John Doe", actualEmployees.get(0).getName());
        assertEquals("Jane Smith", actualEmployees.get(1).getName());
        verify(employeeRepository, times(1)).findAll();
    }

    @Test
    void testGetAllEmployeesEmpty() {
        when(employeeRepository.findAll()).thenReturn(new ArrayList<>());

        List<Employee> employees = employeeService.getAllEmployees();

        assertNotNull(employees);
        assertTrue(employees.isEmpty());
        verify(employeeRepository, times(1)).findAll();
    }

    @Test
    void testAddEmployee() {
        when(employeeRepository.save(any(Employee.class))).thenReturn(testEmployee);

        Employee savedEmployee = employeeService.addEmployee(testEmployee);

        assertNotNull(savedEmployee);
        assertEquals("John Doe", savedEmployee.getName());
        assertEquals("Engineering", savedEmployee.getDepartment());
        assertEquals("john.doe@example.com", savedEmployee.getEmail());
        assertEquals(50000.0, savedEmployee.getSalary());
        verify(employeeRepository, times(1)).save(testEmployee);
    }

    @Test
    void testAddEmployeeWithNullName() {
        Employee employeeWithoutName = new Employee();
        employeeWithoutName.setId(3L);
        employeeWithoutName.setDepartment("HR");

        when(employeeRepository.save(any(Employee.class))).thenReturn(employeeWithoutName);

        Employee result = employeeService.addEmployee(employeeWithoutName);

        assertNotNull(result);
        assertNull(result.getName());
        assertEquals("HR", result.getDepartment());
        verify(employeeRepository, times(1)).save(employeeWithoutName);
    }

    @Test
    void testDeleteEmployee() {
        Long employeeId = 1L;
        doNothing().when(employeeRepository).deleteById(employeeId);

        employeeService.deleteEmployee(employeeId);

        verify(employeeRepository, times(1)).deleteById(employeeId);
    }

    @Test
    void testDeleteNonExistentEmployee() {
        Long employeeId = 999L;
        doNothing().when(employeeRepository).deleteById(employeeId);

        employeeService.deleteEmployee(employeeId);

        verify(employeeRepository, times(1)).deleteById(employeeId);
    }

    @Test
    void testServiceConstructor() {
        assertNotNull(employeeService);
    }
}
