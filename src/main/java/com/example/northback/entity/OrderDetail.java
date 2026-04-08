package com.example.northback.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="orderDetailId")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "orderId")
    private SalesOrder order;
    @ManyToOne
    @JoinColumn(name="productId")
    private Product product;
    private Double unitPrice;
    private Short quantity;
    private Double discount;


}
