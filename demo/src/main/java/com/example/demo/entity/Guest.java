package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Guest {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String firstName;

   private String lastName;

   @Column(unique = true)
   private String email;

   @Column(unique = true)
   private String phoneNumber;

   @OneToMany(mappedBy = "guest", cascade = CascadeType.ALL)
   private List<Booking> bookings;
}
