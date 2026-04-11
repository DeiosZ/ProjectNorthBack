package com.example.northback.service;

import com.example.northback.DTO.*;
import com.example.northback.entity.Customer;
import com.example.northback.entity.Employee;
import com.example.northback.entity.SalesOrder;
import com.example.northback.repository.SalesOrderRepository;
import jakarta.transaction.Transactional;
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

    @Transactional
    public SalesOrderWithOrderDetailDTO ordenCompleta(Long id){
        SalesOrder s = repo.findById(id).orElseThrow(()->new RuntimeException("Orden no encontrada"));
        Customer c = s.getCustomer();
        Employee e = s.getEmployee();
        List<OrderDetailDTO> detalles  = s.getDetails()
                .stream()
                .map(d->{
                    double subtotal  = d.getUnitPrice() *d.getQuantity() *(1-d.getDiscount());
                    return new OrderDetailDTO(
                            d.getProduct().getProductName(),
                            d.getQuantity(),
                            d.getUnitPrice(),
                            d.getDiscount(),
                            subtotal
                    );
                })
                .toList();
        double total = detalles.stream()
                .mapToDouble(OrderDetailDTO::getSubtotal)
                .sum();

        return  new SalesOrderWithOrderDetailDTO(
                s.getId(),
                s.getOrderDate(),
                s.getRequiredDate(),
                c.getCompanyName(),
                c.getContactName(),
                e.getFirstname()+" "+e.getLastname(),
                s.getShipAddress(),
                s.getShipCity(),
                s.getShipCountry(),
                detalles,
                total
        );
    }


    public CustomerDTO customerDeOrden(Long id) {
        SalesOrder order = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada"));

        Customer c = order.getCustomer();

        return new CustomerDTO(
                c.getId(),
                c.getCompanyName(),
                c.getContactName(),
                c.getPhone(),
                c.getEmail()
        );
    }

    public EmployeeDTO obtenerEmpleadoDeOrden(Long orderId) {
        SalesOrder order = repo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada"));

        Employee e = order.getEmployee();

        return new EmployeeDTO(
                e.getId(),
                e.getLastname(),
                e.getFirstname(),
                e.getTitle(),
                e.getEmail()
        );
    }
}
