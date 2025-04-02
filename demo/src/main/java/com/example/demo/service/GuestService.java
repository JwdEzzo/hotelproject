package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Guest;

import com.example.demo.repository.GuestRepository;

@Service
public class GuestService {

   @Autowired
   private GuestRepository guestRepository;

   // Create a Guest
   public Guest createGuest(Guest thisGuest) {
      return guestRepository.save(thisGuest);
   }

   // Find by First Name
   public List<Guest> findGuestByFirstName(String firstName) {
      return guestRepository.findGuestByFirstName(firstName);
   }

   // Find by Last Name
   public List<Guest> findGuestByLastName(String lastName) {
      return guestRepository.findGuestByLastName(lastName);
   }

   // Find by First Name and Last Name
   public List<Guest> findGuestByName(String firstName, String lastName) {
      return guestRepository.findGuestByName(firstName, lastName);
   }

   // Find By Email
   public Guest findByEmail(String email) {
      return guestRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Guest not found!"));
   }

   // Read ALL Guests
   public List<Guest> getAllGuests() {
      return guestRepository.findAll();
   }

   // Find Guest by Booking
   public Guest findGuestByBooking(Long bookingId) {
      return guestRepository.findByBookingsId(bookingId).orElseThrow(() -> new RuntimeException("Guest not found!"));
   }

   // Read a Guest by Id
   public Guest getGuestById(Long id) {
      return guestRepository.findById(id).orElseThrow(() -> new RuntimeException("Guest not found!"));
   }

   // Update a Guest
   public Guest updateGuest(Long id, Guest guestDetails) {
      Guest oldGuest = guestRepository.findById(id).orElseThrow(() -> new RuntimeException("Guest not found!"));

      oldGuest.setFirstName(guestDetails.getFirstName());
      oldGuest.setLastName(guestDetails.getLastName());
      oldGuest.setEmail(guestDetails.getEmail());
      oldGuest.setPhoneNumber(guestDetails.getPhoneNumber());

      return guestRepository.save(oldGuest);
   }

   // Delete a Guest
   public void deleteGuest(Long id) {
      guestRepository.deleteById(id);
   }

}
