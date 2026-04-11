package com.example.northback.service;

import com.example.northback.DTO.EmployeeDTO;
import com.example.northback.entity.Employee;
import com.example.northback.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repo;

    public List<EmployeeDTO> obtenerEmpleados(){
        return repo.findAll()
                .stream()
                .map(e->new EmployeeDTO(e.getId(), e.getLastname(), e.getFirstname(),e.getTitle() ,e.getEmail()))
                .toList();
    }
    public EmployeeDTO empleadoPorId(Long id){
        Employee e = repo.findById(id)
                .orElseThrow(()->new RuntimeException("Empleado no encontrado"));
        return new EmployeeDTO(
                e.getId(),
                e.getLastname(),
                e.getFirstname(),
                e.getTitle(),
                e.getEmail()
        );
    }
}
