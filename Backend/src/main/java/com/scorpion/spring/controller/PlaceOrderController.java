package com.scorpion.spring.controller;

import com.scorpion.spring.datatransfer.OrderDTO;
import com.scorpion.spring.service.PlaceOrderService;
import com.scorpion.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("place-order")
public class PlaceOrderController {

    @Autowired
    private PlaceOrderService service;

    @GetMapping(path = "customer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getCustomer(@PathVariable String id){
        return new ResponseUtil(200,"Found Customer...",service.getCustomer(id));
    }

    @GetMapping(path = "item/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getItem(@PathVariable String code){
        return new ResponseUtil(200,"Found Item...",service.getItem(code));
    }

    @GetMapping(path = "id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getOrderId(){
        return new ResponseUtil(200,"Order ID Generated Successfully...",service.getOrderId());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil purchaseOrder(@RequestBody OrderDTO dto){
        service.purchaseOrder(dto);
        return new ResponseUtil(200,"Order Purchased Successfully...",null);
    }
}
