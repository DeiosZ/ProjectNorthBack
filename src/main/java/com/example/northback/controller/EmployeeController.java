package com.example.northback.controller;

import com.example.northback.DTO.EmployeeDTO;
import com.example.northback.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    @GetMapping("/")
    public List<EmployeeDTO> obtenerEmpleados(){
        return service.obtenerEmpleados();
    }
    @GetMapping("/{id}")
    public EmployeeDTO empleadoPorId(@PathVariable Long id){
        return service.empleadoPorId(id);
    }
}
