package com.final_task.dealership.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.final_task.dealership.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

}
