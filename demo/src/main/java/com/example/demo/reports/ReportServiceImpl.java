package com.example.demo.reports;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Booking;
import com.example.demo.entity.Guest;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.RoomRepository;

@Service
public class ReportServiceImpl implements ReportService {

   @Autowired
   private BookingRepository bookingRepository;

   @Autowired
   private RoomRepository roomRepository;

   // Method: calculateTotalRevenue
   @Override
   public BigDecimal calculateTotalRevenue(LocalDateTime start, LocalDateTime end) {
      List<Booking> bookings = bookingRepository.findBookingsBetweenDates(start, end);
      return bookings.stream().map(Booking::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
   }

   // Method: calculateOccupancyRate
   @Override
   public double calculateOccupancyRate(LocalDateTime start, LocalDateTime end) {
      List<Booking> bookings = bookingRepository.findBookingsBetweenDates(start, end);
      return bookings.size() / (double) roomRepository.count();
   }

   // Method: getGuestBookingHistory
   @Override
   public List<Booking> getGuestBookingHistory(Long guestId) {
      Guest guest = new Guest();
      guest.setId(guestId);
      return bookingRepository.findByGuest(guest);
   }

}
