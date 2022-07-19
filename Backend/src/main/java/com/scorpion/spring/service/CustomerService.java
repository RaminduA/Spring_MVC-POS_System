package com.scorpion.spring.service;

import com.scorpion.spring.datatransfer.CustomerDTO;
import com.scorpion.spring.entity.Customer;
import org.modelmapper.TypeToken;

import java.util.List;

public interface CustomerService {
    CustomerDTO getCustomer(String id);
    List<CustomerDTO> getAllCustomers();
    List<String> getAllCustomerIds();
    void saveCustomer(CustomerDTO dto);
    void updateCustomer(CustomerDTO dto);
    void deleteCustomer(String id);
}
