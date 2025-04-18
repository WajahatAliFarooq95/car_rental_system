package com.carrental.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "rentals")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    private double totalPrice;

    // Constructors
    protected Rental() {} // JPA required

    public Rental(Car car, String customerName, LocalDate startDate, LocalDate endDate) {
        this.car = car;
        this.customerName = customerName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters/Setters
    public Long getId() { return id; }
    public Car getCar() { return car; }
    public String getCustomerName() { return customerName; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public double getTotalPrice() { return totalPrice; }

    public void calculateTotalPrice(double dailyRate) {
        this.totalPrice = dailyRate * java.time.temporal.ChronoUnit.DAYS.between(startDate, endDate);
    }
}