package com.example.northback.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ProductId")
    private Long id;
    private String productName;
    @ManyToOne
    @JoinColumn(name="supplierId")
    private Supplier supplier;//estoy diciendo esta columna puede tener un producto y muchas compañias abastecedoras
    @ManyToOne
    @JoinColumn(name="categoryId")
    private Category category;
    private String quantityPerUnit;
    private Double unitPrice;
    private Short unitsInStock;
    private Short unitsOnOrder;
    private Short reorderLevel;
    @Column(length = 1)
    private String discontinued;

}
