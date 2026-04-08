package com.example.northback.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalesOrderWithOrderDetailDTO {
    private Long orderId;
    private LocalDateTime orderDate;
    private LocalDateTime requiredDate;
    private List<OrderDetailDTO> details;
}
