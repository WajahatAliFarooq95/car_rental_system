package com.carrental.dto;

import com.carrental.model.Car;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarDTO {
    private Long id;
    private String make;
    private String model;
    private int year;
    private boolean available;
    private List<RentalDTO> rentals = Collections.emptyList();

    public CarDTO() {
    }

    public CarDTO(Long id, String make, String model, int year, boolean available) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.available = available;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public boolean isAvailable() { return available; }
    public List<RentalDTO> getRentals() { return rentals; }

    public void setId(Long id) { this.id = id; }
    public void setMake(String make) { this.make = make; }
    public void setModel(String model) { this.model = model; }
    public void setYear(int year) { this.year = year; }
    public void setAvailable(boolean available) { this.available = available; }
    public void setRentals(List<RentalDTO> rentals) { this.rentals = rentals; }

    public static CarDTO fromEntity(Car car) {
        CarDTO carDTO = new CarDTO();
        carDTO.setId(car.getId());
        carDTO.setMake(car.getMake());
        carDTO.setModel(car.getModel());
        carDTO.setYear(car.getYear());
        carDTO.setAvailable(car.isAvailable());
        carDTO.setRentals(car.getRentals().stream()
                .map(RentalDTO::fromEntity)
                .collect(Collectors.toList()));
        return carDTO;
    }
}