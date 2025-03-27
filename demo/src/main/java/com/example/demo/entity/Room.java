package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
public class Room {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "room_number", unique = true, nullable = false)
        private String roomNumber;

        @Column(name = "room_type", nullable = false)
        private String roomType;

        @Column(name = "price_per_night", nullable = false)
        private double pricePerNight;

        @Column(name = "availability_status", nullable = false)
        private boolean availabilityStatus;

        @ManyToMany(mappedBy = "rooms", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
        @JsonIgnore
        private List<HotelService> services;

        @OneToOne(mappedBy = "room", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
        private Booking booking;


}