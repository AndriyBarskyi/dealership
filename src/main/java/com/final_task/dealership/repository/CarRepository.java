package com.final_task.dealership.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.final_task.dealership.model.Car;
import com.final_task.dealership.model.Customer;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {

}
