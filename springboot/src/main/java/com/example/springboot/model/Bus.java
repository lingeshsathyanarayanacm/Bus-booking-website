package com.example.springboot.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String busName;

    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL)
    private List<User> users;

    // Constructors, getters, and setters
    public Bus() {
    }

    public Bus(String busName) {
        this.busName = busName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
