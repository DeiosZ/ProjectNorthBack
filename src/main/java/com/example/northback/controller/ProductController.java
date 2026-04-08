package com.example.northback.controller;

import com.example.northback.DTO.ProductDTO;
import com.example.northback.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @RequestMapping("/")
    public List<ProductDTO> listarProductos(){
        return service.listarProductos();
    }

    @RequestMapping("/{id}")
    public ProductDTO productoPorId(@PathVariable Long id){
        return service.productoPorId(id);
    }
}
