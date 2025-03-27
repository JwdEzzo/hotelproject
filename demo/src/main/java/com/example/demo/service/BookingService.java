package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Booking;
import com.example.demo.entity.Guest;
import com.example.demo.entity.Room;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.GuestRepository;
import com.example.demo.repository.RoomRepository;

@Service
public class BookingService {

   @Autowired
   private BookingRepository bookingRepository;

   @Autowired
   private RoomRepository roomRepository;

   @Autowired
   private GuestRepository guestRepository;

   // Create a booking
   public Booking createBooking(Booking thisBooking) {
      return bookingRepository.save(thisBooking);
   }

   // Read All Bookings
   public List<Booking> getAllBookings() {
      return bookingRepository.findAll();
   }

   // Read booking by Id
   public Booking getBookingById(Long id) {
      return bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
   }

   // Update a Booking
   public Booking updateBooking(Long id, Booking bookingDetails) {
      Booking oldBooking = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));

      oldBooking.setCheckInDate(bookingDetails.getCheckInDate());
      oldBooking.setCheckOutDate(bookingDetails.getCheckOutDate());
      return bookingRepository.save(oldBooking);

   }

   // Delete a Booking
   public void deleteBooking(Long id) {
      bookingRepository.deleteById(id);
   }

   // Associate a Booking with a Room
   public void associateBookingWithRoom(Long bookingId, Long roomId) {
      Booking thisBooking = bookingRepository.findById(bookingId).orElseThrow(() -> new RuntimeException("This Booking Doesnt exist"));

      Room thisRoom = roomRepository.findById(roomId).orElseThrow(() -> new RuntimeException("This Booking Doesnt exist"));

      thisBooking.setRoom(thisRoom);
      bookingRepository.save(thisBooking);
   }

   // Associate Booking with Guest
   public void associateBookingWithGuest(Long bookingId, Long guestId) {
      Booking thisBooking = bookingRepository.findById(bookingId).orElseThrow(() -> new RuntimeException("This Booking Doesnt exist"));

      Guest thisGuest = guestRepository.findById(guestId).orElseThrow(() -> new RuntimeException("This  Booking Doesnt exist"));

      thisBooking.setGuest(thisGuest);
      bookingRepository.save(thisBooking);
   }
}
