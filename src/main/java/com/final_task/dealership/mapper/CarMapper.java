package com.final_task.dealership.mapper;

import java.util.List;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import com.final_task.dealership.dto.CarDTO;
import com.final_task.dealership.dto.CarSaveDTO;
import com.final_task.dealership.model.Car;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CarMapper {
    Car dtoToEntity(CarDTO carDTO);

    CarDTO entityToDto(Car car);

    CarSaveDTO entityToSaveDto(Car car);

    Car saveDtoToEntity(CarSaveDTO carSaveDTO);

    List<CarDTO> entiesToDtos(List<Car> cars);
}