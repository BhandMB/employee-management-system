package com.example.employeemanagement.controller;

import com.example.employeemanagement.dto.EmployeeRequest;
import com.example.employeemanagement.dto.EmployeeResponse;
import com.example.employeemanagement.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService service;
    public EmployeeController(EmployeeService service) { this.service = service; }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','HR','EMPLOYEE')")
    public Page<EmployeeResponse> search(@RequestParam(defaultValue = "") String search,
                                         @RequestParam(defaultValue = "") String department,
                                         @RequestParam(required = false) Boolean active,
                                         @RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "10") int size) {
        int safePage = Math.max(page, 0), safeSize = Math.min(Math.max(size, 1), 50);
        return service.search(search, department, active, PageRequest.of(safePage, safeSize, Sort.by("name").ascending()));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','HR','EMPLOYEE')")
    public EmployeeResponse get(@PathVariable Long id) { return service.get(id); }

    @GetMapping("/stats")
    @PreAuthorize("hasAnyRole('ADMIN','HR','EMPLOYEE')")
    public Map<String, Object> stats() {
        Map<String, Object> m = new LinkedHashMap<>();
        m.put("totalEmployees", service.getTotalEmployees()); m.put("activeEmployees", service.getActiveEmployees());
        m.put("departments", service.getDepartmentCount()); m.put("payroll", service.getTotalPayroll());
        m.put("departmentStats", service.getDepartmentStats()); return m;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','HR')")
    public ResponseEntity<EmployeeResponse> add(@Valid @RequestBody EmployeeRequest request) { return ResponseEntity.ok(service.add(request)); }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','HR')")
    public EmployeeResponse update(@PathVariable Long id, @Valid @RequestBody EmployeeRequest request) { return service.update(id, request); }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
