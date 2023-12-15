package com.final_task.dealership.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.final_task.dealership.dto.CustomerDTO;
import com.final_task.dealership.dto.CustomerSaveDTO;

@Service
public interface CustomerService {

    CustomerDTO getCustomerById(String id);

    CustomerSaveDTO updateCustomer(String id, CustomerSaveDTO customerSaveDTO);

    void deleteCustomer(String id);

    CustomerDTO addNewCustomer(CustomerSaveDTO customerSaveDTO);

    List<CustomerDTO> getAllCustomers();
}
