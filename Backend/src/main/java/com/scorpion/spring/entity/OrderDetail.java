package com.scorpion.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@IdClass(OrderDetailPK.class)
public class OrderDetail {
    @Id
    private String orderId;
    @Id
    private String itemCode;
    private double unitPrice;
    private int quantity;
    private double subtotal;

    @ManyToOne
    @JoinColumn(name="orderId", referencedColumnName="id", insertable=false, updatable=false)
    private Orders order;

    @ManyToOne
    @JoinColumn(name="itemCode", referencedColumnName="code", insertable=false, updatable=false)
    private Item item;
}
