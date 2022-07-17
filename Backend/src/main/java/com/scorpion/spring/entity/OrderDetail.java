package com.scorpion.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class OrderDetail {
    @Id
    private String orderId;
    @Id
    private String itemCode;
    private double unitPrice;
    private int quantity;
    private double subtotal;
}
