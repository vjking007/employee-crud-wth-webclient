package com.example.employee_service.service;

import com.example.employee_service.dto.EmployeeDTO;
import com.example.employee_service.dto.EmployeeRequest;
import com.example.employee_service.exception.ResourceNotFoundException;
import com.example.employee_service.model.Employee;
import com.example.employee_service.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeDTO create(EmployeeRequest employeeRequest) {
        Employee employee = mapToEntity(employeeRequest);
        return mapToDto(repository.save(employee));
    }

    public EmployeeDTO getById(Long id) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        return mapToDto(employee);
    }

    public List<EmployeeDTO> getAll() {
        return repository.findAll().stream().map(this::mapToDto).toList();
    }

    public EmployeeDTO update(Long id, EmployeeRequest employeeRequest) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        employee.setName(employeeRequest.getName());
        employee.setEmail(employeeRequest.getEmail());
        employee.setDepartment(employeeRequest.getDepartment());
        return mapToDto(repository.save(employee));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    // Mapping methods
    private EmployeeDTO mapToDto(Employee emp) {
        return new EmployeeDTO(emp.getId(),emp.getName(), emp.getEmail(), emp.getDepartment());
    }

    private Employee mapToEntity(EmployeeRequest employeeRequest) {
        Employee employee=new Employee();
        employee.setName(employeeRequest.getName());
        employee.setEmail(employeeRequest.getEmail());
        employee.setDepartment(employeeRequest.getDepartment());
        return employee;
    }
}

