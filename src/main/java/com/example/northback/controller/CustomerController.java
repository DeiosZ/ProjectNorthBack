package com.example.northback.controller;

import com.example.northback.DTO.CustomerDTO;
import com.example.northback.service.CustomerService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping("/")
    public List<CustomerDTO> obtenerClientes(){
        return service.obtenerCustomers();
    }

    @GetMapping("/{id}")
    public CustomerDTO clientePorId(@PathVariable Long id){
        return service.customerPorId(id);
    }
}
