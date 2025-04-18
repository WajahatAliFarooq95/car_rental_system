package com.carrental.testservice;

import com.carrental.dto.CarDTO;
import com.carrental.model.Car;
import com.carrental.service.CarService;
import com.carrental.dao.CarRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarService carService;

    @Test
    void getAllAvailableCars_shouldReturnAvailableCarsOnly() {
        // Arrange - Create test data
        Car availableCar1 = new Car("Toyota", "Camry", 2023);
        Car availableCar2 = new Car("Honda", "Accord", 2022);
        Car rentedCar = new Car("BMW", "X5", 2023);
        rentedCar.setAvailable(false);

        // Mock repository behavior
        when(carRepository.findAll())
            .thenReturn(Arrays.asList(availableCar1, availableCar2));

        // Act
        List<CarDTO> result = carService.getAllAvailableCars();

        // Assert
        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(CarDTO::isAvailable));
        verify(carRepository, times(1)).findAll();
    }

    @Test
    void getAllAvailableCars_shouldReturnEmptyListWhenNoCarsAvailable() {
        // Arrange
        when(carRepository.findAll()).thenReturn(List.of());

        // Act
        List<CarDTO> result = carService.getAllAvailableCars();

        // Assert
        assertTrue(result.isEmpty());
        verify(carRepository, times(1)).findAll();
    }
}