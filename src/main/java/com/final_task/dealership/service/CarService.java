package com.final_task.dealership.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.final_task.dealership.dto.CarDTO;
import com.final_task.dealership.dto.CarSaveDTO;

@Service
public interface CarService {

    CarDTO getCarById(String id);

    CarSaveDTO updateCar(String id, CarSaveDTO carSaveDTO);

    void deleteCar(String id);

    CarDTO addNewCar(CarSaveDTO carSaveDTO);

    List<CarDTO> getAllCars();
}
