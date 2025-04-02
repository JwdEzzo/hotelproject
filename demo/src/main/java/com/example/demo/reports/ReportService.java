package com.example.demo.reports;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.entity.Booking;

public interface ReportService {
   BigDecimal calculateTotalRevenue(LocalDateTime start, LocalDateTime end);

   double calculateOccupancyRate(LocalDateTime start, LocalDateTime end);

   List<Booking> getGuestBookingHistory(Long guestId);
}
