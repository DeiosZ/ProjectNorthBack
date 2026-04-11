package com.example.northback.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalesOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="orderId")
    private Long id;
    @ManyToOne
    @JoinColumn(name="custId")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name="employeeId")
    private Employee employee;
    private LocalDateTime orderDate;
    private LocalDateTime requiredDate;
    private LocalDateTime shippedDate;
    private Double  freight;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipRegion;
    private String shipPostalCode;
    private String shipCountry;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL ,orphanRemoval = true)
    private List<OrderDetail> details;
}
