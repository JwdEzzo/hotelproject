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

import com.example.demo.entity.Guest;
import com.example.demo.service.GuestService;

@RestController
@RequestMapping("/guests")
public class GuestController {

   @Autowired
   private GuestService guestService;

   // POST -- Create a Booking
   @PostMapping()
   public Guest createGuest(@RequestBody Guest Guest) {
      return guestService.createGuest(Guest);
   }

   // GET -- Read ALL Bookings
   @GetMapping()
   public List<Guest> getAllGuests() {
      return guestService.getAllGuests();
   }

   // GET -- Read a Booking by Id
   @GetMapping("/{id}")
   public Guest getGuestById(@PathVariable Long id) {
      return guestService.getGuestById(id);
   }

   // PUT -- Update a Booking
   @PutMapping("/{id}")
   public Guest updateGuest(@PathVariable Long id, @RequestBody Guest guestDetails) {
      return guestService.updateGuest(id, guestDetails);
   }

   // DELETE -- Delete a Booking
   @DeleteMapping("/{id}")
   public void deleteGuest(@PathVariable Long id) {
      guestService.deleteGuest(id);
   }

   // POST -- Associate Guest With Room

   @PostMapping("/associateguestwithroom")
   public void associateGuestWithRoom(@RequestBody Map<String,Long> guestRoomMap) {
      Long roomId = guestRoomMap.get("roomId");
      Long guestId = guestRoomMap.get("guestId");

      guestService.associateGuestWithRoom(guestId, roomId);
   }
}
