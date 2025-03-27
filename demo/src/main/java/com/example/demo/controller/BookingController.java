package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Booking;
import com.example.demo.service.BookingService;
import com.example.demo.service.GuestService;
import com.example.demo.service.RoomService;

@RestController
@RequestMapping("/bookings")
public class BookingController {

   @Autowired
   private BookingService bookingService;

   // POST -- Create a Booking
   @PostMapping()
   public Booking createBooking(@RequestBody Booking booking) {
      return bookingService.createBooking(booking);
   }

   // GET -- Read ALL Bookings
   @GetMapping()
   public List<Booking> getAllBookings() {
      return bookingService.getAllBookings();
   }

   // GET -- Read a Booking by Id
   @GetMapping("/{id}")
   public Booking getBookingById(@PathVariable Long id) {
      return bookingService.getBookingById(id);
   }

   // PUT -- Update a Booking
   @PutMapping("/{id}")
   public Booking updateBooking(@PathVariable Long id, @RequestBody Booking bookingDetails) {
      return bookingService.updateBooking(id, bookingDetails);
   }

   // DELETE -- Delete a Booking
   @DeleteMapping("/{id}")
   public void deleteBooking(@PathVariable Long id) {
      bookingService.deleteBooking(id);
   }

   // POST -- Associate Booking With Guest
   @PostMapping("/associatebookingwithguest")
   public void associateBookingWithGuest(@RequestBody Map<String, Long> guestBookingMap) {
      Long bookingId = guestBookingMap.get("bookingId");
      Long guestId = guestBookingMap.get("guestId");

      bookingService.associateBookingWithGuest(bookingId, guestId);
   }

   // POST -- Associate Booking With Guest
   @PostMapping("/associatebookingwithroom")
   public void associateBookingWithroom(@RequestBody Map<String, Long> guestRoomMap) {
      Long bookingId = guestRoomMap.get("bookingId");
      Long roomId = guestRoomMap.get("roomId");

      bookingService.associateBookingWithRoom(bookingId, roomId);
   }

}
