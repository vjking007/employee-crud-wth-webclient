package com.example.employee_service.controller;

import com.example.employee_service.dto.EmployeeDTO;
import com.example.employee_service.dto.EmployeeRequest;
import com.example.employee_service.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Tag(name = "Employee API", description = "CRUD APIs for Employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @Operation(summary = "Create new employee")
    @PostMapping
    public EmployeeDTO create(@RequestBody EmployeeRequest employeeRequest) {
        return service.create(employeeRequest);
    }

    @Operation(summary = "Get employee by ID")
    @GetMapping("/{id}")
    public EmployeeDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @Operation(summary = "List all employees")
    @GetMapping
    public List<EmployeeDTO> getAll() {
        return service.getAll();
    }

    @Operation(summary = "Update employee")
    @PutMapping("/{id}")
    public EmployeeDTO update(@PathVariable Long id, @RequestBody EmployeeRequest employeeRequest) {
        return service.update(id, employeeRequest);
    }

    @Operation(summary = "Delete employee")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Deleted");
    }
}
