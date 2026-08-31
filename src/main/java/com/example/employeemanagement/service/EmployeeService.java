package com.example.employeemanagement.service;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee addEmployee(Employee emp) {
        emp.setActive(true);
        return repository.save(emp);
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }

    public long getTotalEmployees() {
        return repository.count();
    }

    public long getActiveEmployees() {
        return repository.countByActiveTrue();
    }

    public long getDepartmentCount() {
        return repository.countDepartments();
    }

    public double getTotalPayroll() {
        return repository.totalActivePayroll();
    }
}
