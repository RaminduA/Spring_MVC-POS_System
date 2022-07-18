package com.scorpion.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class OrderDetail {
    @Id
    @GeneratedValue
    private int id;
    private String orderId;
    private String itemCode;
    private double unitPrice;
    private int quantity;
    private double subtotal;

    @ManyToOne
    private Order order;
    @ManyToOne
    private Item item;
}
