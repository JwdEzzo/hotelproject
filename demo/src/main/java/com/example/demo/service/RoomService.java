package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Room;
import com.example.demo.enums.RoomStatus;
import com.example.demo.enums.RoomType;

import com.example.demo.repository.RoomRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class RoomService {

   @Autowired
   private RoomRepository roomRepository;

   // Create a Room
   public Room createRoom(Room thisRoom) {
      return roomRepository.save(thisRoom);
   }

   // Read a Room by Room Number
   public Room getRoomByRoomNumber(String roomNumber) {
      return roomRepository.findByRoomNumber(roomNumber);
   }

   // Read Rooms by Room Type
   public List<Room> getRoomByRoomType(RoomType roomType) {
      return roomRepository.findByRoomType(roomType);
   }

   // Read a Room by Room Status
   public List<Room> getRoomByRoomStatus(RoomStatus roomStatus) {
      return roomRepository.findByRoomStatus(roomStatus);
   }

   // Read ALL Available Rooms
   public List<Room> getAvailableRooms(LocalDateTime checkIn, LocalDateTime checkOut) {
      return roomRepository.findAvailableRooms(checkIn, checkOut);
   }

   // Read ALL Rooms
   public List<Room> getAllRooms() {
      return roomRepository.findAll();
   }

   // Read a Room by Id
   public Room getRoomById(Long id) {
      return roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room not found"));
   }

   // Update a Room
   public Room updateRoom(Long id, Room roomDetails) {
      Room oldRoom = roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room not found"));

      oldRoom.setPricePerNight(roomDetails.getPricePerNight());
      oldRoom.setRoomStatus(roomDetails.getRoomStatus());
      oldRoom.setRoomNumber(roomDetails.getRoomNumber());
      oldRoom.setRoomType(roomDetails.getRoomType());

      return roomRepository.save(oldRoom);
   }

   // Delete a Room
   @Transactional
   public void deleteRoom(Long roomId) {
      if (roomRepository.existsById(roomId)) {
         roomRepository.deleteById(roomId);
      } else {
         throw new EntityNotFoundException("Room not found with id: " + roomId);
      }
   }
}
