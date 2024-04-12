package com.example.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bookingDetails;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    // Constructors, getters, and setters
    public Booking() {
    }

    public Booking(String bookingDetails) {
        this.bookingDetails = bookingDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookingDetails() {
        return bookingDetails;
    }

    public void setBookingDetails(String bookingDetails) {
        this.bookingDetails = bookingDetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
