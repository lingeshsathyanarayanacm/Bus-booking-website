package com.example.springboot.repository;

import com.example.springboot.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface BusRepo extends JpaRepository<Bus, Integer> {

    @Query("SELECT b FROM Bus b WHERE b.busName = ?1")
    List<Bus> findByBusName(String busName);
    
    @Query("SELECT b FROM Bus b WHERE b.id IN (SELECT DISTINCT b.id FROM Bus b INNER JOIN b.users u WHERE u.id = ?1)")
    List<Bus> findByUserId(int userId);
}
