package com.scorpion.spring.service;

import com.scorpion.spring.datatransfer.CustomerDTO;
import com.scorpion.spring.datatransfer.ItemDTO;
import com.scorpion.spring.datatransfer.OrderDTO;

public interface PlaceOrderService {
    String getOrderId();
    CustomerDTO getCustomer(String id);
    ItemDTO getItem(String code);
    void purchaseOrder(OrderDTO dto);
}
