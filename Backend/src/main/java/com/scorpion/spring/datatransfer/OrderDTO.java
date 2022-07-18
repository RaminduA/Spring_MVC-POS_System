package com.scorpion.spring.datatransfer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class OrderDTO {
    private String id;
    private String date;
    private String time;
    private double cost;
    private CustomerDTO customer;
    private List<OrderDetailDTO> detailList;
}
