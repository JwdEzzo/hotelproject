package com.example.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import lombok.Data;
import jakarta.persistence.GenerationType;

@Entity
@Data
public class Booking {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      private LocalDateTime checkInDateTime;

      private LocalDateTime checkOutDateTime;

      private BigDecimal totalPrice;

      @ManyToOne
      @JoinColumn(name = "room_id")
      private Room room;

      @ManyToOne
      @JoinColumn(name = "guest_id")
      private Guest guest;

      // @ManyToMany
      // @JoinTable(
      //             /* */ name = "booking_hotelService",
      //             /* */ joinColumns = @JoinColumn(name = "booking_id"),
      //             /* */ inverseJoinColumns = @JoinColumn(name = "hotelService_id")
      // /* */ /* */ )
      // private List<HotelService> hotelServices;

}
