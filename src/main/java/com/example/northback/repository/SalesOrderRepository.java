package com.example.northback.repository;

import com.example.northback.entity.SalesOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesOrderRepository extends JpaRepository<SalesOrder,Long> {
}
