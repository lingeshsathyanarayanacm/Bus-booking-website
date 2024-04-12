package com.example.springboot.repository;

import com.example.springboot.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking, Integer> {
}
