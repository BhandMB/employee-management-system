package com.example.employeemanagement.dto;

public record EmployeeResponse(Long id, String name, String department, String email, double salary, boolean active) {}
