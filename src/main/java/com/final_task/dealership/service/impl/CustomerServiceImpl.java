package com.final_task.dealership.service.impl;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.final_task.dealership.dto.CustomerDTO;
import com.final_task.dealership.dto.CustomerSaveDTO;
import com.final_task.dealership.exception.EntityNotExistsException;
import com.final_task.dealership.mapper.CustomerMapper;
import com.final_task.dealership.model.Customer;
import com.final_task.dealership.repository.CustomerRepository;
import com.final_task.dealership.service.CustomerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final MessageSource messageSource;

    @Override public CustomerDTO getCustomerById(String id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return customerMapper.entityToDto(customer.get());
        } else {
            throw new EntityNotExistsException(
                messageSource.getMessage("error.entity.not.exists", new Object[] { "Customer" },
                    Locale.getDefault()));
        }
    }

    @Override public CustomerSaveDTO updateCustomer(String id,
        CustomerSaveDTO customerSaveDTO){
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            Customer customerEntity = customerMapper.saveDtoToEntity(customerSaveDTO);
            customerEntity.setId(id);
            customerRepository.save(customerEntity);
            return customerSaveDTO;
        } else {
            throw new EntityNotExistsException(
                messageSource.getMessage("error.entity.not.exists", new Object[] { "Customer" },
                    Locale.getDefault()));
        }
    }

    @Override public void deleteCustomer(String id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            customerRepository.deleteById(id);
        } else {
            throw new EntityNotExistsException(
                messageSource.getMessage("error.entity.not.exists", new Object[] { "Customer" },
                    Locale.getDefault()));
        }
    }

    @Override
    public CustomerDTO addNewCustomer(CustomerSaveDTO customerSaveDTO) {
        Customer customerEntity = customerMapper.saveDtoToEntity(customerSaveDTO);
        customerRepository.save(customerEntity);
        return customerMapper.entityToDto(customerEntity);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customerMapper.entiesToDtos(customers);
    }

}
