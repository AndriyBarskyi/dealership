package com.final_task.dealership.service.impl;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.final_task.dealership.dto.CarDTO;
import com.final_task.dealership.dto.CarSaveDTO;
import com.final_task.dealership.exception.EntityNotExistsException;
import com.final_task.dealership.mapper.CarMapper;
import com.final_task.dealership.model.Car;
import com.final_task.dealership.repository.CarRepository;
import com.final_task.dealership.service.CarService;
import com.final_task.dealership.service.CarService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;
    private final MessageSource messageSource;

    @Override public CarDTO getCarById(String id) {
        Optional<Car> car = carRepository.findById(id);
        if (car.isPresent()) {
            return carMapper.entityToDto(car.get());
        } else {
            throw new EntityNotExistsException(
                messageSource.getMessage("error.entity.not.exists", new Object[] { "Car" },
                    Locale.getDefault()));
        }
    }

    @Override public CarSaveDTO updateCar(String id,
        CarSaveDTO carSaveDTO){
        Optional<Car> car = carRepository.findById(id);
        if (car.isPresent()) {
            Car carEntity = carMapper.saveDtoToEntity(carSaveDTO);
            carEntity.setId(id);
            carRepository.save(carEntity);
            return carSaveDTO;
        } else {
            throw new EntityNotExistsException(
                messageSource.getMessage("error.entity.not.exists", new Object[] { "Car" },
                    Locale.getDefault()));
        }
    }

    @Override public void deleteCar(String id) {
        Optional<Car> car = carRepository.findById(id);
        if (car.isPresent()) {
            carRepository.deleteById(id);
        } else {
            throw new EntityNotExistsException(
                messageSource.getMessage("error.entity.not.exists", new Object[] { "Car" },
                    Locale.getDefault()));
        }
    }

    @Override
    public CarDTO addNewCar(CarSaveDTO carSaveDTO) {
        Car carEntity = carMapper.saveDtoToEntity(carSaveDTO);
        carRepository.save(carEntity);
        return carMapper.entityToDto(carEntity);
    }

    @Override
    public List<CarDTO> getAllCars() {
        List<Car> cars = carRepository.findAll();
        return carMapper.entiesToDtos(cars);
    }

}
