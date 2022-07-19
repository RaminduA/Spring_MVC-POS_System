package com.scorpion.spring.repository;

import com.scorpion.spring.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Orders,String> {
    Orders findTopByOrderByIdDesc();
}
