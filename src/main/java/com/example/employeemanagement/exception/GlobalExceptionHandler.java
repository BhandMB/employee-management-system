package com.example.employeemanagement.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,Object> notFound(EmployeeNotFoundException ex) { return error(404, ex.getMessage()); }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,Object> validation(MethodArgumentNotValidException ex) {
        Map<String,Object> body = error(400, "Validation failed");
        Map<String,String> fields = new LinkedHashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(e -> fields.put(e.getField(), e.getDefaultMessage()));
        body.put("fields", fields); return body;
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String,Object> conflict() { return error(409, "A record with the supplied unique value already exists"); }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,Object> generic() { return error(500, "An unexpected server error occurred"); }

    private Map<String,Object> error(int status, String message) {
        Map<String,Object> m = new LinkedHashMap<>(); m.put("timestamp", Instant.now()); m.put("status", status); m.put("message", message); return m;
    }
}
