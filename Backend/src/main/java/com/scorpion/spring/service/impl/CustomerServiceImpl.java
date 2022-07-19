package com.scorpion.spring.service.impl;

import com.scorpion.spring.datatransfer.CustomerDTO;
import com.scorpion.spring.entity.Customer;
import com.scorpion.spring.repository.CustomerRepo;
import com.scorpion.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo repo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CustomerDTO getCustomer(String id){
        if(!repo.findById(id).isPresent()){
            throw new RuntimeException("Customer "+id+" Doesn't Exist...");
        }
        return modelMapper.map(repo.findById(id).get(), CustomerDTO.class);
    }

    @Override
    public List<CustomerDTO> getAllCustomers(){
        return modelMapper.map(repo.findAll(), new TypeToken<List<Customer>>(){}.getType());
    }

    @Override
    public List<String> getAllCustomerIds(){
        return repo.getAllIds();
    }

    @Override
    public void saveCustomer(CustomerDTO dto){
        if (repo.findById(dto.getId()).isPresent()) {
            throw new RuntimeException("Customer Already Exists...");
        }
        repo.save(modelMapper.map(dto, Customer.class));
    }

    @Override
    public void updateCustomer(CustomerDTO dto){
        if (!repo.findById(dto.getId()).isPresent()) {
            throw new RuntimeException("Customer Doesn't Exist...");
        }
        repo.save(modelMapper.map(dto, Customer.class));
    }

    @Override
    public void deleteCustomer(String id){
        if (!repo.findById(id).isPresent()) {
            throw new RuntimeException("Customer "+id+" Doesn't Exist...");
        }
        repo.deleteById(id);
    }
}
