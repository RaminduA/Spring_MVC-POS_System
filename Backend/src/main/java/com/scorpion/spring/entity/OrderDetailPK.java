package com.scorpion.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetailPK implements Serializable {
    private String orderId;
    private String itemCode;
}
