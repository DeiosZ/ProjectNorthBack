package com.example.northback.service;

import com.example.northback.DTO.OrderDetailDTO;
import com.example.northback.DTO.SalesOrderDTO;
import com.example.northback.DTO.SalesOrderWithOrderDetailDTO;
import com.example.northback.entity.SalesOrder;
import com.example.northback.repository.SalesOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesOrderService {
    @Autowired
    private SalesOrderRepository repo;

    public List<SalesOrderDTO> listarOrdenes(){
        return repo.findAll()
                .stream()
                .map(s->new SalesOrderDTO(s.getId(),s.getOrderDate(),s.getRequiredDate()))
                .toList();
    }

    public SalesOrderDTO ordenPorId(Long id){
        SalesOrder s= repo.findById(id).orElseThrow(()->new RuntimeException("Orden no encontrada"));
        return new SalesOrderDTO(
                s.getId(),
                s.getOrderDate(),
                s.getRequiredDate()
        );
    }

    public SalesOrderWithOrderDetailDTO ordenCompleta(Long id){
        SalesOrder s = repo.findById(id).orElseThrow(()->new RuntimeException("Orden no encontrada"));
        return new SalesOrderWithOrderDetailDTO(
                s.getId(),
                s.getOrderDate(),
                s.getRequiredDate(),
                s.getDetails()
                        .stream()
                        .map(d-> new OrderDetailDTO(
                                d.getProduct().getProductName(),
                                d.getQuantity(),
                                d.getUnitPrice()
                        ))
                        .toList()

        );
    }

}
