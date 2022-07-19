package com.scorpion.spring.service.impl;

import com.scorpion.spring.datatransfer.CustomerDTO;
import com.scorpion.spring.datatransfer.ItemDTO;
import com.scorpion.spring.datatransfer.OrderDTO;
import com.scorpion.spring.entity.Item;
import com.scorpion.spring.entity.OrderDetail;
import com.scorpion.spring.entity.Orders;
import com.scorpion.spring.repository.CustomerRepo;
import com.scorpion.spring.repository.ItemRepo;
import com.scorpion.spring.repository.OrderRepo;
import com.scorpion.spring.repository.OrderDetailRepo;
import com.scorpion.spring.service.PlaceOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class PlaceOrderServiceImpl implements PlaceOrderService {

    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    ItemRepo itemRepo;
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    OrderDetailRepo detailRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public String getOrderId() {
        return null;
    }

    @Override
    public CustomerDTO getCustomer(String id) {
        if(!customerRepo.findById(id).isPresent()){
            throw new RuntimeException("Customer "+id+" Doesn't Exist...");
        }
        return modelMapper.map(customerRepo.findById(id).get(), CustomerDTO.class);
    }

    @Override
    public ItemDTO getItem(String code) {
        if(!itemRepo.findById(code).isPresent()){
            throw new RuntimeException("Item "+code+" Doesn't Exist...");
        }
        return modelMapper.map(itemRepo.findById(code).get(), ItemDTO.class);
    }

    @Override
    public void purchaseOrder(OrderDTO dto) {
        Orders order = modelMapper.map(dto, Orders.class);
        if(!orderRepo.existsById(dto.getId())){

            orderRepo.save(order);

            if(dto.getDetailList().isEmpty()){
                throw new RuntimeException("Your Cart is Empty...");
            }

            for(OrderDetail detail: order.getDetailList()){
                Item item = itemRepo.findById(detail.getItemCode()).orElse(new Item());
                item.setQuantity(item.getQuantity()-detail.getQuantity());
                itemRepo.save(item);
            }

        }else{
            throw new RuntimeException("Order "+dto.getId()+" Already Exists...");
        }
    }
}
