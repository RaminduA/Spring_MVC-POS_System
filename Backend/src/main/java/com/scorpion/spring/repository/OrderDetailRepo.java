package com.scorpion.spring.repository;

import com.scorpion.spring.entity.OrderDetail;
import com.scorpion.spring.entity.OrderDetailPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepo extends JpaRepository<OrderDetail, OrderDetailPK> {

}
