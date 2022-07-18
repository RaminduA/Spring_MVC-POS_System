package com.scorpion.spring.repository;

import com.scorpion.spring.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,String> {

}
