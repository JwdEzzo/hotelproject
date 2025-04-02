package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import com.example.demo.enums.RoomStatus;
import com.example.demo.enums.RoomType;

@Entity
@Data
public class Room {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(unique = true)
        private String roomNumber;

        @Enumerated(EnumType.STRING)
        private RoomType roomType;

        @Enumerated(EnumType.STRING)
        private RoomStatus roomStatus;

        private double pricePerNight;

        @OneToMany(mappedBy = "room", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
        private List<Booking> booking;

}