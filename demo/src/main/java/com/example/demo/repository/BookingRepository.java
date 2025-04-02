package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Booking;
import com.example.demo.entity.Guest;

public interface BookingRepository extends JpaRepository<Booking, Long> {

   // Find Booking By Guest
   public List<Booking> findByGuest(Guest guest);

   // Find Booking Between checkInDates and checkOutDates
   @Query("SELECT b FROM Booking b WHERE b.checkInDateTime BETWEEN :start AND :end ")
   public List<Booking> findBookingsBetweenDates(LocalDateTime start, LocalDateTime end);
}
