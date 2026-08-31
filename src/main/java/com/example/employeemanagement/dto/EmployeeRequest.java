package com.example.employeemanagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public record EmployeeRequest(
        @NotBlank(message = "Name is required") String name,
        @NotBlank(message = "Department is required") String department,
        @NotBlank(message = "Email is required") @Email(message = "Enter a valid email address") String email,
        @PositiveOrZero(message = "Salary cannot be negative") double salary,
        Boolean active
) {}
