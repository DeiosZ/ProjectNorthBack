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
public class Employee {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="employeeId")
        private Long id;
        private String lastname;
        private String firstname;
        private String title;
        private String titleOfCourtesy;
        private LocalDateTime birthDate;
        private LocalDateTime hireDate;
        private String address;
        private String city;
        private String region;
        private String postalCode;
        private String country;
        private String phone;
        private String extension;
        private String mobile;
        private String email;
        @Lob
        private byte[] photo;
        @Lob
        private byte[] notes;
        private String photoPath;

        @ManyToOne
        @JoinColumn(name = "mgrId")
        private Employee manager;

        @OneToMany(mappedBy = "employee")
        private List<SalesOrder> salesOrders;

}
