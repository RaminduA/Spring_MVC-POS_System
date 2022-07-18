package com.scorpion.spring.datatransfer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class OrderDetailDTO {
    private String orderId;
    private String itemCode;
    private double unitPrice;
    private int quantity;
    private double subtotal;
}
