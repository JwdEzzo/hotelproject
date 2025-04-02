package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long> {

   // Find by First Name
   @Query("SELECT g FROM Guest g WHERE g.firstName = ?1")
   public List<Guest> findGuestByFirstName(String firstName);

   // Find by Last Name
   @Query("SELECT g FROM Guest g WHERE g.lastName = ?1")
   public List<Guest> findGuestByLastName(String lastName);

   // Find by First Name and Last Name
   @Query("SELECT g FROM Guest g WHERE g.firstName = ?1 and g.lastName = ?2")
   public List<Guest> findGuestByName(String firstName, String lastName);

   // Find By Email
   @Query("SELECT g FROM Guest g WHERE g.email = ?1")
   public Optional<Guest> findByEmail(String email);

   // Find Guest by Booking
   public Optional<Guest> findByBookingsId(Long bookingId);

   // // Or JPQL version
   // @Query("SELECT g FROM Guest g JOIN g.bookings b WHERE b.id = :bookingId")
   // Guest findGuestByBookingId(@Param("bookingId") Long bookingId);
}
