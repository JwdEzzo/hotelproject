package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Guest;
import com.example.demo.service.GuestService;

@RestController
@RequestMapping("/guests")
public class GuestController {

   @Autowired
   private GuestService guestService;

   // POST -- Create a Guest
   @PostMapping()
   public Guest createGuest(@RequestBody Guest Guest) {
      return guestService.createGuest(Guest);
   }

   // GET -- Get a Guest by First Name
   @GetMapping("/firstname/{firstName}")
   public List<Guest> findGuestByFirstName(@PathVariable String firstName) {
      return guestService.findGuestByFirstName(firstName);
   }

   // GET -- Get a Guest by Last Name
   @GetMapping("/lastname/{lastName}")
   public List<Guest> findGuestByLastName(@PathVariable String lastName) {
      return guestService.findGuestByLastName(lastName);
   }

   // GET -- Get a Guest by First Name and Last Name
   @GetMapping("/name/{firstName}/{lastName}")
   public List<Guest> findGuestByName(@PathVariable String firstName, @PathVariable String lastName) {
      return guestService.findGuestByName(firstName, lastName);
   }

   // GET -- Get a Guest by Email
   @GetMapping("/email/{email}")
   public Guest findByEmail(@PathVariable String email) {
      return guestService.findByEmail(email);
   }

   // GET -- Get ALL Guests
   @GetMapping()
   public List<Guest> getAllGuests() {
      return guestService.getAllGuests();
   }

   // GET -- Get Guest By Booking
   @GetMapping("/booking/{bookingId}")
   public Guest findGuestByBooking(@PathVariable Long bookingId) {
      return guestService.findGuestByBooking(bookingId);
   }

   // GET -- Get a Guest by Id
   @GetMapping("/{id}")
   public Guest getGuestById(@PathVariable Long id) {
      return guestService.getGuestById(id);
   }

   // PUT -- Update a Guest
   @PutMapping("/{id}")
   public Guest updateGuest(@PathVariable Long id, @RequestBody Guest guestDetails) {
      return guestService.updateGuest(id, guestDetails);
   }

   // DELETE -- Delete a Guest
   @DeleteMapping("/{id}")
   public void deleteGuest(@PathVariable Long id) {
      guestService.deleteGuest(id);
   }

}
