package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.HotelService;
import com.example.demo.entity.Room;
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
      oldRoom.setAvailabilityStatus(roomDetails.isAvailabilityStatus());
      oldRoom.setRoomNumber(roomDetails.getRoomNumber());
      oldRoom.setRoomType(roomDetails.getRoomType());

      return roomRepository.save(oldRoom);
   }

   // Delete a Room
   @Transactional
   public void deleteRoom(Long roomId) {
      Room room = roomRepository.findById(roomId)
         .orElseThrow(() -> new EntityNotFoundException("Room not found"));
      
      // Manually remove associations from the other side
      for (HotelService service : room.getServices()) {
         service.getRooms().remove(room);
      }
      
      // Clear local associations
      room.getServices().clear();
      
      // First save to update relationships
      roomRepository.save(room);
      
      // Then delete
      roomRepository.delete(room);
   }

}
