package com.scorpion.spring.service.impl;

import com.scorpion.spring.datatransfer.CustomerDTO;
import com.scorpion.spring.repository.CustomerRepo;
import com.scorpion.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo repo;

    @Autowired
    private ModelMapper modelMapper;

    public CustomerDTO getCustomer(String id){
        if(!repo.findById(id).isPresent()){
            throw new RuntimeException("Customer "+id+" doesn't exist...");
        }
        return modelMapper.map(repo.findById(id).get(), CustomerDTO.class);
    }

}
