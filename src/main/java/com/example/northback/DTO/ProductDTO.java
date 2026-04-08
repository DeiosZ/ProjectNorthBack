package com.example.northback.DTO;

import com.example.northback.entity.Supplier;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {
    private String productName;
    private String supplierCompanyName;
    private Double unitPrice;
}
