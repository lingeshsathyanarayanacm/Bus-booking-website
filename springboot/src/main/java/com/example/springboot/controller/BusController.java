package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springboot.model.Bus;
import com.example.springboot.service.BusService;

import java.util.List;

@RestController
@RequestMapping("/api/bus")
public class BusController {

    @Autowired
    private BusService busService;

    @PostMapping
    public ResponseEntity<Bus> addBus(@RequestBody Bus bus) {
        Bus newBus = busService.create(bus);
        return new ResponseEntity<>(newBus, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Bus>> getAllBuses() {
        List<Bus> buses = busService.getAllBuses();
        return new ResponseEntity<>(buses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bus> getBusById(@PathVariable("id") int id) {
        Bus bus = busService.getBusById(id).orElse(null);
        if (bus != null) {
            return new ResponseEntity<>(bus, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bus> updateBus(@PathVariable("id") int id, @RequestBody Bus bus) {
        if (busService.updateBus(id, bus)) {
            return new ResponseEntity<>(bus, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteBus(@PathVariable("id") int id) {
        if (busService.deleteBus(id)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<Bus>> getAllBusesSorted(@RequestParam String sortBy) {
        List<Bus> buses = busService.getAllBusesSortedBy(sortBy);
        return new ResponseEntity<>(buses, HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Bus>> getAllBusesPaginated(@RequestParam int pageNo, @RequestParam int pageSize) {
        Page<Bus> busesPage = busService.getAllBusesPaginated(pageNo, pageSize);
        return new ResponseEntity<>(busesPage, HttpStatus.OK);
    }
    @GetMapping("/name/{busName}")
    public ResponseEntity<List<Bus>> getBusesByBusName(@PathVariable String busName) {
        List<Bus> buses = busService.findByBusName(busName);
        return new ResponseEntity<>(buses, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Bus>> getBusesByUserId(@PathVariable int userId) {
        List<Bus> buses = busService.findByUserId(userId);
        return new ResponseEntity<>(buses, HttpStatus.OK);
    }
}
