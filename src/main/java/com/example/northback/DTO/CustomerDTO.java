package com.example.northback.DTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private Long id;
    private String companyName;
    private String contactName;
    private String phone;
    private String email;
}
