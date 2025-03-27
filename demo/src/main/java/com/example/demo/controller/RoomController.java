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
import com.example.demo.entity.Room;
import com.example.demo.service.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {

   @Autowired
   private RoomService roomService;

   // POST -- Create a Booking
   @PostMapping()
   public Room createRoom(@RequestBody Room room) {
      return roomService.createRoom(room);
   }

   // GET -- Read ALL Bookings
   @GetMapping()
   public List<Room> getAllRooms() {
      return roomService.getAllRooms();
   }

   // GET -- Read a Booking by Id
   @GetMapping("/{id}")
   public Room getRoomById(@PathVariable Long id) {
      return roomService.getRoomById(id);
   }

   // PUT -- Update a Booking
   @PutMapping("/{id}")
   public Room updateRoom(@PathVariable Long id, @RequestBody Room roomDetails) {
      return roomService.updateRoom(id, roomDetails);
   }

   // DELETE -- Delete a Booking
   @DeleteMapping("/{id}")
   public void deleteRoom(@PathVariable Long id) {
      roomService.deleteRoom(id);
   }

}
