package com.example.employeemanagement.repository;

import com.example.employeemanagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    long countByActiveTrue();
    long countDistinctByDepartmentIsNotNullAndDepartmentNot(String department);

    @Query("select count(distinct e.department) from Employee e where e.department is not null and trim(e.department) <> ''")
    long countDepartments();

    @Query("select coalesce(sum(e.salary), 0) from Employee e where e.active = true")
    double totalActivePayroll();
}
