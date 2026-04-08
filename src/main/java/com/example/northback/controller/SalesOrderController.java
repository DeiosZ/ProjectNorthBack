package com.example.northback.controller;

import com.example.northback.DTO.SalesOrderDTO;
import com.example.northback.DTO.SalesOrderWithOrderDetailDTO;
import com.example.northback.service.SalesOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ordenes")
public class SalesOrderController {
    @Autowired
    private SalesOrderService service;

    @GetMapping("/")
    public List<SalesOrderDTO> listarOrdenes(){
        return service.listarOrdenes();
    }

    @GetMapping("/{id}")
    public SalesOrderWithOrderDetailDTO ordenCompleta(@PathVariable Long id){
        return service.ordenCompleta(id);
    }
}
