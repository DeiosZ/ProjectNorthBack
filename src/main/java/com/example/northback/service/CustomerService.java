package com.example.northback.service;

import com.example.northback.DTO.CustomerDTO;
import com.example.northback.entity.Customer;
import com.example.northback.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repo;

    public List<CustomerDTO> obtenerCustomers(){
        return repo.findAll()
                .stream()
                .map(c->new CustomerDTO(c.getId(),c.getCompanyName(),c.getContactName(),c.getPhone(),c.getEmail()))
                .toList();
    }

    public CustomerDTO customerPorId(Long id){
        Customer c   = repo.findById(id)
                .orElseThrow(()->new RuntimeException("Cliente no encontrado"));
        return new CustomerDTO(
                c.getId(),
                c.getCompanyName(),
                c.getContactName(),
                c.getPhone(),
                c.getEmail()
        );
    }
}
