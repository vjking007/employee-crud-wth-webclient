package com.example.employee_client.Service;

import com.example.employee_client.dto.EmployeeDTO;
import com.example.employee_client.dto.EmployeeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeClientService {

    @Autowired
    private WebClient webClient;

    public Mono<EmployeeDTO> create(EmployeeRequest employeeRequest) {
        return webClient.post().uri("/api/employees").bodyValue(employeeRequest)
                .retrieve().bodyToMono(EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAll() {
        return webClient.get().uri("/api/employees")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<EmployeeDTO>>() {})
                .block();
    }

    public EmployeeDTO getById(Long id) {
        return webClient
                .get()
                .uri("/api/employees/{id}", id)
                .retrieve()
                .bodyToMono(EmployeeDTO.class)
                .block();
    }

    public Mono<EmployeeDTO> update(Long id, EmployeeDTO dto) {
        return webClient.put().uri("/api/employees/{id}", id)
                .bodyValue(dto).retrieve().bodyToMono(EmployeeDTO.class);
    }

    public Mono<Void> delete(Long id) {
        return webClient.delete().uri("/api/employees/{id}", id)
                .retrieve().bodyToMono(Void.class);
    }
}

