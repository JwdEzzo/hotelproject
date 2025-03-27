package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Guest;
import com.example.demo.entity.Room;
import com.example.demo.repository.GuestRepository;
import com.example.demo.repository.RoomRepository;

@Service
public class GuestService {

   @Autowired
   private GuestRepository guestRepository;

   @Autowired
   private RoomRepository roomRepository;

   // Create a Guest
   public Guest createGuest(Guest thisGuest) {
      return guestRepository.save(thisGuest);
   }

   // Read ALL Guest
   public List<Guest> getAllGuests() {
      return guestRepository.findAll();
   }

   // Read a Guest by Id
   public Guest getGuestById(Long id) {
      return guestRepository.findById(id).orElseThrow(() -> new RuntimeException("Guest not found!"));
   }

   // Update a Guest
   public Guest updateGuest(Long id, Guest guestDetails) {
      Guest oldGuest = guestRepository.findById(id).orElseThrow(() -> new RuntimeException("Guest not found!"));

      oldGuest.setAddress(guestDetails.getAddress());
      oldGuest.setContact(guestDetails.getContact());
      oldGuest.setName(guestDetails.getName());

      return guestRepository.save(oldGuest);
   }

   // Delete a Guest
   public void deleteGuest(Long id) {
      guestRepository.deleteById(id);
   }


   //  Associate a Guest with a Room
   public void associateGuestWithRoom(Long guestId, Long roomId) {
      Room thisRoom = roomRepository.findById(roomId).orElseThrow(()-> new RuntimeException("This Room doesnt exist"));
     
      Guest thisGuest = guestRepository.findById(guestId).orElseThrow(()-> new RuntimeException("This Guest doesnt exist"));
      
      thisGuest.setRoom(thisRoom);

      guestRepository.save(thisGuest);

      thisRoom.setAvailabilityStatus(false);

      roomRepository.save(thisRoom);

   }
}
