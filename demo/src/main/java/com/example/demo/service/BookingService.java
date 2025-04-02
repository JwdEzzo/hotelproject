package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Booking;
import com.example.demo.entity.Guest;
import com.example.demo.entity.Room;
import com.example.demo.enums.RoomStatus;
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

      oldBooking.setCheckInDateTime(bookingDetails.getCheckInDateTime());
      oldBooking.setCheckOutDateTime(bookingDetails.getCheckOutDateTime());
      oldBooking.setTotalPrice(bookingDetails.getTotalPrice());
      return bookingRepository.save(oldBooking);

   }

   // Delete a Booking
   public void deleteBooking(Long id) {
      bookingRepository.deleteById(id);
   }

   // Associate a Booking with a Room
   public void associateBookingWithRoom(Long bookingId, Long roomId) {
      Booking thisBooking = bookingRepository.findById(bookingId)
            .orElseThrow(() -> new RuntimeException("This Booking Doesnt exist"));

      Room thisRoom = roomRepository.findById(roomId)
            .orElseThrow(() -> new RuntimeException("This Room Doesnt exist"));

      if (thisRoom.getRoomStatus() != RoomStatus.AVAILABLE) {
         throw new RuntimeException("Room is not available. Current status: " + thisRoom.getRoomStatus());
      } else {
         System.out.println(" This room is Available");
         thisRoom.setRoomStatus(RoomStatus.valueOf("OCCUPIED"));
         thisBooking.setRoom(thisRoom);
         bookingRepository.save(thisBooking);
         roomRepository.save(thisRoom);
      }
   }

   // Associate Booking with Guest
   public void associateBookingWithGuest(Long bookingId, Long guestId) {
      // Get the Booking that you want to associate
      Booking thisBooking = bookingRepository.findById(bookingId)
            .orElseThrow(() -> new RuntimeException("This Booking Doesnt exist"));

      // Get the Guest that you want to associate
      Guest thisGuest = guestRepository.findById(guestId)
            .orElseThrow(() -> new RuntimeException("This Guest Doesnt exist"));

      // Get the room from the booking
      Room thisRoom = thisBooking.getRoom();
      System.out.println("Current room status: " + thisRoom.getRoomStatus());

      if (thisRoom.getRoomStatus() != RoomStatus.AVAILABLE) {
         throw new RuntimeException("Room is not available. Current status: " + thisRoom.getRoomStatus());
      } else {
         System.out.println(" This room is Available");
         thisRoom.setRoomStatus(RoomStatus.valueOf("OCCUPIED"));
         thisBooking.setGuest(thisGuest);
         bookingRepository.save(thisBooking);
         roomRepository.save(thisRoom);
      }
   }
}
