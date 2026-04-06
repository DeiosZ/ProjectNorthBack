package com.example.northback.service;

import com.example.northback.DTO.SupplierDTO;
import com.example.northback.entity.Supplier;
import com.example.northback.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository repo;

    public List<SupplierDTO> listarSuppliers(){
        return repo.findAll()
                .stream()
                .map(s-> new SupplierDTO(s.getCompanyName(),s.getPhone()))
                .toList();
    }

    public SupplierDTO supplierPorId(Long id){
        Supplier s = repo.findById(id)
                .orElseThrow(()->new RuntimeException("Supplier no encontrado"));
        return new SupplierDTO(
                s.getCompanyName(),
                s.getPhone()
        );

    }
}
