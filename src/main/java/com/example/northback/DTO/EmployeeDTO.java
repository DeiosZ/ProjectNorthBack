package com.example.northback.DTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String lastname;
    private String firstname;
    private String title;
    private String email;
}
