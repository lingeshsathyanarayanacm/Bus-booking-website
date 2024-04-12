package com.example.springboot.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.springboot.model.Bus;
import com.example.springboot.repository.BusRepo;

@Service
public class BusService {

    @Autowired
    BusRepo busRepository;

    public Bus create(Bus bus) {
        return busRepository.save(bus);
    }

    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    public Optional<Bus> getBusById(int id) {
        return busRepository.findById(id);
    }

    public boolean updateBus(int id, Bus bus) {
        if (!busRepository.existsById(id)) {
            return false;
        }
        bus.setId(id);
        busRepository.save(bus);
        return true;
    }

    public boolean deleteBus(int id) {
        if (!busRepository.existsById(id)) {
            return false;
        }
        busRepository.deleteById(id);
        return true;
    }

    public List<Bus> getAllBusesSortedBy(String sortBy) {
        return busRepository.findAll(Sort.by(sortBy));
    }

    public Page<Bus> getAllBusesPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return busRepository.findAll(pageable);
    }
    public List<Bus> findByBusName(String busName) {
        return busRepository.findByBusName(busName);
    }

    public List<Bus> findByUserId(int userId) {
        return busRepository.findByUserId(userId);
    }

}
