package com.example.employeemanagement.service;

import com.example.employeemanagement.dto.EmployeeRequest;
import com.example.employeemanagement.dto.EmployeeResponse;
import com.example.employeemanagement.exception.EmployeeNotFoundException;
import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;
    public EmployeeService(EmployeeRepository repository) { this.repository = repository; }

    public Page<EmployeeResponse> search(String search, String department, Boolean active, Pageable pageable) {
        return repository.search(search == null ? "" : search.trim(), department == null ? "" : department.trim(), active, pageable).map(this::toResponse);
    }

    @Transactional public EmployeeResponse add(EmployeeRequest r) {
        Employee e = new Employee(); copy(r, e); e.setActive(true); return toResponse(repository.save(e));
    }

    @Transactional public EmployeeResponse update(Long id, EmployeeRequest r) {
        Employee e = repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        copy(r, e); return toResponse(repository.save(e));
    }

    @Transactional public void delete(Long id) {
        if (!repository.existsById(id)) throw new EmployeeNotFoundException(id);
        repository.deleteById(id);
    }

    public EmployeeResponse get(Long id) { return repository.findById(id).map(this::toResponse).orElseThrow(() -> new EmployeeNotFoundException(id)); }
    public long getTotalEmployees() { return repository.count(); }
    public long getActiveEmployees() { return repository.countByActiveTrue(); }
    public long getDepartmentCount() { return repository.countDepartments(); }
    public double getTotalPayroll() { return repository.totalActivePayroll(); }
    public List<DepartmentStat> getDepartmentStats() { return repository.employeeCountByDepartment().stream().map(r -> new DepartmentStat(String.valueOf(r[0]), ((Number) r[1]).longValue())).toList(); }

    private void copy(EmployeeRequest r, Employee e) {
        e.setName(r.name()); e.setDepartment(r.department()); e.setEmail(r.email()); e.setSalary(r.salary());
        if (r.active() != null) e.setActive(r.active());
    }
    private EmployeeResponse toResponse(Employee e) { return new EmployeeResponse(e.getId(), e.getName(), e.getDepartment(), e.getEmail(), e.getSalary(), e.isActive()); }
    public record DepartmentStat(String department, long employees) {}
}
