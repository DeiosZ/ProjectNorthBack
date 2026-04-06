package com.example.northback.controller;

import com.example.northback.DTO.SupplierDTO;
import com.example.northback.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {
    @Autowired
    private  SupplierService service;

    @GetMapping("/")
    public List<SupplierDTO> listarSuppliers(){
        return service.listarSuppliers();
    }

    @GetMapping("/{id}")
    public SupplierDTO obtenerSupplier(@PathVariable Long id){
        return service.supplierPorId(id);
    }
}
