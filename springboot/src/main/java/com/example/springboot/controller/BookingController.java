package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springboot.model.Booking;
import com.example.springboot.service.BookingService;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {
        Booking newBooking = bookingService.create(booking);
        return new ResponseEntity<>(newBooking, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable("id") int id) {
        Booking booking = bookingService.getBookingById(id).orElse(null);
        if (booking != null) {
            return new ResponseEntity<>(booking, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable("id") int id, @RequestBody Booking booking) {
        if (bookingService.updateBooking(id, booking)) {
            return new ResponseEntity<>(booking, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteBooking(@PathVariable("id") int id) {
        if (bookingService.deleteBooking(id)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<Booking>> getAllBookingsSorted(@RequestParam String sortBy) {
        List<Booking> bookings = bookingService.getAllBookingsSortedBy(sortBy);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Booking>> getAllBookingsPaginated(@RequestParam int pageNo, @RequestParam int pageSize) {
        Page<Booking> bookingsPage = bookingService.getAllBookingsPaginated(pageNo, pageSize);
        return new ResponseEntity<>(bookingsPage, HttpStatus.OK);
    }
}
