package com.scorpion.spring.controller;

import com.scorpion.spring.datatransfer.CustomerDTO;
import com.scorpion.spring.service.CustomerService;
import com.scorpion.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getCustomer(@PathVariable String id){
        return new ResponseUtil(200,"Found Customer...",service.getCustomer(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCustomers(){
        return new ResponseUtil(200,"Found Customer List...",service.getAllCustomers());
    }

    @GetMapping(path = "ids", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCustomerIds(){
        return new ResponseUtil(200,"Found All Customer IDs...",service.getAllCustomerIds());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCustomer(@RequestBody CustomerDTO dto){
        service.saveCustomer(dto);
        return new ResponseUtil(200,"Customer Saved Successfully...",null);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO dto){
        service.updateCustomer(dto);
        return new ResponseUtil(200,"Customer Updated Successfully...",null);
    }

    @DeleteMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCustomer(@PathVariable String id){
        service.deleteCustomer(id);
        return new ResponseUtil(200,"Customer Deleted Successfully...",null);
    }
}
