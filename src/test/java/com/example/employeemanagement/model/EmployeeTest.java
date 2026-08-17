package com.example.employeemanagement.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = new Employee();
    }

    @Test
    void testSetAndGetId() {
        Long testId = 1L;
        employee.setId(testId);
        assertEquals(testId, employee.getId());
    }

    @Test
    void testSetAndGetName() {
        String testName = "John Doe";
        employee.setName(testName);
        assertEquals(testName, employee.getName());
    }

    @Test
    void testSetAndGetDepartment() {
        String testDept = "Engineering";
        employee.setDepartment(testDept);
        assertEquals(testDept, employee.getDepartment());
    }

    @Test
    void testSetAndGetEmail() {
        String testEmail = "john.doe@example.com";
        employee.setEmail(testEmail);
        assertEquals(testEmail, employee.getEmail());
    }

    @Test
    void testSetAndGetSalary() {
        double testSalary = 50000.0;
        employee.setSalary(testSalary);
        assertEquals(testSalary, employee.getSalary());
    }

    @Test
    void testEmployeeInitialState() {
        Employee newEmployee = new Employee();
        assertNull(newEmployee.getId());
        assertNull(newEmployee.getName());
        assertNull(newEmployee.getDepartment());
        assertNull(newEmployee.getEmail());
        assertEquals(0.0, newEmployee.getSalary());
    }

    @Test
    void testSetMultipleFields() {
        Long id = 5L;
        String name = "Jane Smith";
        String department = "Sales";
        String email = "jane.smith@example.com";
        double salary = 60000.0;

        employee.setId(id);
        employee.setName(name);
        employee.setDepartment(department);
        employee.setEmail(email);
        employee.setSalary(salary);

        assertEquals(id, employee.getId());
        assertEquals(name, employee.getName());
        assertEquals(department, employee.getDepartment());
        assertEquals(email, employee.getEmail());
        assertEquals(salary, employee.getSalary());
    }
}
