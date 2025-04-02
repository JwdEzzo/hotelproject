package com.example.demo.controller;

import java.time.LocalDateTime;
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
import com.example.demo.enums.RoomStatus;
import com.example.demo.enums.RoomType;
import com.example.demo.service.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {

   @Autowired
   private RoomService roomService;

   // POST -- Create a Room
   @PostMapping()
   public Room createRoom(@RequestBody Room room) {
      return roomService.createRoom(room);
   }

   // GET -- Get a Room By RoomNumber
   @GetMapping("/roomNumber/{roomNumber}")
   public Room getRoomByRoomNumber(@PathVariable String roomNumber) {
      return roomService.getRoomByRoomNumber(roomNumber);
   }

   // GET -- Get a Room by RoomType
   @GetMapping("/roomType/{roomType}")
   public List<Room> getRoomByRoomType(@PathVariable RoomType roomType) {
      return roomService.getRoomByRoomType(roomType);
   }

   // GET -- Get a Room by RoomStatus
   @GetMapping("/roomStatus/{roomStatus}")
   public List<Room> getRoomByRoomStatus(@PathVariable RoomStatus roomStatus) {
      return roomService.getRoomByRoomStatus(roomStatus);
   }

   // GET -- Get ALL Available Rooms
   @GetMapping("/availableRooms/{checkIn}/{checkOut}")
   public List<Room> getAvailableRooms(@PathVariable LocalDateTime checkIn, @PathVariable LocalDateTime checkOut) {
      return roomService.getAvailableRooms(checkIn, checkOut);
   }

   // GET -- Get ALL Rooms
   @GetMapping()
   public List<Room> getAllRooms() {
      return roomService.getAllRooms();
   }

   // GET -- Get a Room by Id
   @GetMapping("/{id}")
   public Room getRoomById(@PathVariable Long id) {
      return roomService.getRoomById(id);
   }

   // PUT -- Update a Room
   @PutMapping("/{id}")
   public Room updateRoom(@PathVariable Long id, @RequestBody Room roomDetails) {
      return roomService.updateRoom(id, roomDetails);
   }

   // DELETE -- Delete a Room
   @DeleteMapping("/{id}")
   public void deleteRoom(@PathVariable Long id) {
      roomService.deleteRoom(id);
   }

}
