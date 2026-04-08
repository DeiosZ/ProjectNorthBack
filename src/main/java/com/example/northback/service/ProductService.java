package com.example.northback.service;

import com.example.northback.DTO.ProductDTO;
import com.example.northback.entity.Product;
import com.example.northback.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;

    public List<ProductDTO> listarProductos(){
        return repo.findAll()
                .stream()
                .map((p)-> new ProductDTO(
                        p.getId(),
                        p.getProductName(),
                        p.getUnitPrice(),
                        p.getSupplier().getCompanyName(),
                        p.getCategory().getCategoryName()))
                .toList();
    }

    public ProductDTO productoPorId(Long id){
        Product p = repo.findById(id).orElseThrow(()-> new RuntimeException("Producto no encontrado") );
        return new ProductDTO(
                p.getId(),
                p.getProductName(),
                p.getUnitPrice(),
                p.getSupplier() !=null ? p.getSupplier().getCompanyName() :null,
                p.getCategory() != null ? p.getCategory().getCategoryName() : null
                );

    }
}
