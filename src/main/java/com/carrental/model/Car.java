package com.carrental.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cars")
public class Car {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Column(nullable = false)
 private String make;

 @Column(nullable = false)
 private String model;

 private int year;
 private boolean isAvailable;

 @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
 private List<Rental> rentals = new ArrayList<>();

 // Constructors
 protected Car() {} // JPA required

 public Car(String make, String model, int year) {
     this.make = make;
     this.model = model;
     this.year = year;
     this.isAvailable = true;
 }

 // Getters/Setters
 public Long getId() { return id; }
 public String getMake() { return make; }
 public String getModel() { return model; }
 public int getYear() { return year; }
 public boolean isAvailable() { return isAvailable; }
 public List<Rental> getRentals() { return rentals; }

 public void setAvailable(boolean available) { 
     this.isAvailable = available; 
 }
}