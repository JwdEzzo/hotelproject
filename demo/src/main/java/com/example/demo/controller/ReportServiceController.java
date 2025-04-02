package com.example.demo.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Booking;
import com.example.demo.reports.ReportService;

@RestController
@RequestMapping("/reports")
public class ReportServiceController {

   @Autowired
   private ReportService reportService;

   @GetMapping("/revenue")
   public Map<String, Object> getRevenueReport(
         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {

      BigDecimal totalRevenue = reportService.calculateTotalRevenue(startDate, endDate);

      Map<String, Object> response = new HashMap<>();
      response.put("startDate", startDate);
      response.put("endDate", endDate);
      response.put("totalRevenue", totalRevenue);

      return response;
   }

   @GetMapping("/occupancy")
   public Map<String, Object> getOccupancyReport(
         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {

      double occupancyRate = reportService.calculateOccupancyRate(startDate, endDate);

      Map<String, Object> response = new HashMap<>();
      response.put("startDate", startDate);
      response.put("endDate", endDate);
      response.put("occupancyRate", occupancyRate);
      response.put("occupancyPercentage", occupancyRate * 100 + "%");

      return response;
   }

   //    @GetMapping("/guest/{guestId}")
   //    public Map<String, Object> getGuestActivityReport(@PathVariable Long guestId) {
   //       List<Booking> bookingHistory = reportService.getGuestBookingHistory(guestId);

   //       Map<String, Object> response = new HashMap<>();
   //       response.put("guestId", guestId);
   //       response.put("totalBookings", bookingHistory.size());
   //       response.put("bookingHistory", bookingHistory);

   //       return response;
   //    }
}
