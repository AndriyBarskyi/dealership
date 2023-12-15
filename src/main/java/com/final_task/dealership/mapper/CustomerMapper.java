package com.final_task.dealership.mapper;

import java.util.List;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import com.final_task.dealership.dto.CustomerDTO;
import com.final_task.dealership.dto.CustomerSaveDTO;
import com.final_task.dealership.model.Customer;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CustomerMapper {
    Customer dtoToEntity(CustomerDTO customerDTO);

    CustomerDTO entityToDto(Customer customer);

    CustomerSaveDTO entityToSaveDto(Customer customer);

    Customer saveDtoToEntity(CustomerSaveDTO customerSaveDTO);

    List<CustomerDTO> entiesToDtos(List<Customer> customers);
}