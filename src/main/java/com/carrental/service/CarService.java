package com.carrental.service;

import com.carrental.dto.CarDTO;
import com.carrental.model.Car;
import com.carrental.dao.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<CarDTO> getAllAvailableCars() {
        return carRepository.findAll().stream().map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private CarDTO convertToDTO(Car car) {
        return new CarDTO(
                car.getId(),
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.isAvailable()
        );
    }
}