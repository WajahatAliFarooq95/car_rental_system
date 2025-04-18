package com.carrental.dto;

import com.carrental.model.Rental;
import java.time.LocalDate;

public class RentalDTO {
    private Long id;
    private Long carId;
    private String customerName;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalPrice;

    public RentalDTO() {
    }

    public RentalDTO(Long carId, String customerName, LocalDate startDate, LocalDate endDate) {
        this.carId = carId;
        this.customerName = customerName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public Long getCarId() { return carId; }
    public String getCustomerName() { return customerName; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public double getTotalPrice() { return totalPrice; }

    public void setId(Long id) { this.id = id; }
    public void setCarId(Long carId) { this.carId = carId; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }

    public static RentalDTO fromEntity(Rental rental) {
        RentalDTO rentalDTO = new RentalDTO();
        rentalDTO.setId(rental.getId());
        rentalDTO.setCarId(rental.getCar().getId());
        rentalDTO.setCustomerName(rental.getCustomerName());
        rentalDTO.setStartDate(rental.getStartDate());
        rentalDTO.setEndDate(rental.getEndDate());
        rentalDTO.setTotalPrice(rental.getTotalPrice());
        return rentalDTO;
    }
}