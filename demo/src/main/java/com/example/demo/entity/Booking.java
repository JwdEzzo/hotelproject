package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Entity
@Data
public class Booking {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   // Check in dates
   private String checkInDate;

   // Check out dates
   private String checkOutDate;

   @OneToOne
   @JoinColumn(name = "guest_id")
   private Guest guest;

   @OneToOne
   @JoinColumn(name = "room_id")
   private Room room;

}
