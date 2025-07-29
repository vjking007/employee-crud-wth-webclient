package com.example.employee_client;

import com.example.employee_client.Service.EmployeeClientService;
import com.example.employee_client.dto.EmployeeDTO;
import com.example.employee_client.dto.EmployeeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/client/employees")
@RequiredArgsConstructor
public class ClientController {

    private final EmployeeClientService employeeClientService;

    @PostMapping
    public Mono<EmployeeDTO> create(@RequestBody EmployeeRequest employeeRequest) {
        return employeeClientService.create(employeeRequest);
    }

    @GetMapping
    public List<EmployeeDTO> getAll() {
        return employeeClientService.getAll();
    }

    @GetMapping("/{id}")
    public EmployeeDTO getById(@PathVariable Long id) {
        return employeeClientService.getById(id);
    }

    @PutMapping("/{id}")
    public Mono<EmployeeDTO> update(@PathVariable Long id, @RequestBody EmployeeDTO dto) {
        return employeeClientService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id) {
        return employeeClientService.delete(id);
    }
}

