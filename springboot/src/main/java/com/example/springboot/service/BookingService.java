package com.example.springboot.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.springboot.model.Booking;
import com.example.springboot.repository.BookingRepo;

@Service
public class BookingService {

    @Autowired
    BookingRepo bookingRepository;

    public Booking create(Booking booking) {
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(int id) {
        return bookingRepository.findById(id);
    }

    public boolean updateBooking(int id, Booking booking) {
        if (!bookingRepository.existsById(id)) {
            return false;
        }
        booking.setId(id);
        bookingRepository.save(booking);
        return true;
    }

    public boolean deleteBooking(int id) {
        if (!bookingRepository.existsById(id)) {
            return false;
        }
        bookingRepository.deleteById(id);
        return true;
    }

    public List<Booking> getAllBookingsSortedBy(String sortBy) {
        return bookingRepository.findAll(Sort.by(sortBy));
    }

    public Page<Booking> getAllBookingsPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return bookingRepository.findAll(pageable);
    }
}
