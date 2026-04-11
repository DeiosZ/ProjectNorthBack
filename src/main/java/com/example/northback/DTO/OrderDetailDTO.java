package com.example.northback.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDTO {
    private String productName;
    private Short quantity;
    private Short unitPrice;
    private Double discount;
    private Double subtotal;
}
