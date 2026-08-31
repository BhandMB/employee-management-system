package com.example.employeemanagement.repository;

import com.example.employeemanagement.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    long countByActiveTrue();

    @Query("select count(distinct e.department) from Employee e where e.department is not null and trim(e.department) <> ''")
    long countDepartments();

    @Query("select coalesce(sum(e.salary), 0) from Employee e where e.active = true")
    double totalActivePayroll();

    @Query("select e from Employee e where " +
           "(:search is null or :search = '' or lower(e.name) like lower(concat('%', :search, '%')) " +
           "or lower(e.email) like lower(concat('%', :search, '%')) " +
           "or lower(e.department) like lower(concat('%', :search, '%'))) " +
           "and (:department is null or :department = '' or lower(e.department) = lower(:department)) " +
           "and (:active is null or e.active = :active)")
    Page<Employee> search(@Param("search") String search,
                          @Param("department") String department,
                          @Param("active") Boolean active,
                          Pageable pageable);

    @Query("select e.department, count(e) from Employee e group by e.department order by count(e) desc")
    java.util.List<Object[]> employeeCountByDepartment();
}
