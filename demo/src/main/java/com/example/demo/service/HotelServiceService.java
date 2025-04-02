package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.HotelService;
import com.example.demo.entity.Room;
import com.example.demo.repository.HotelServiceRepository;
import com.example.demo.repository.RoomRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class HotelServiceService {

   @Autowired
   private RoomRepository roomRepository;

   @Autowired
   private HotelServiceRepository hotelServiceRepository;

   //Create a Hotel Service
   @Transactional
   public HotelService createHotelService(HotelService thisHotelService) {
      return hotelServiceRepository.save(thisHotelService);
   }

   // Get ALL HotelServices
   public List<HotelService> getAllHotelServices() {
      return hotelServiceRepository.findAll();
   }

   // Get Hotel Service By Id
   public HotelService getHotelServiceById(Long id) {
      return hotelServiceRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("HotelService not found with id: " + id));
   }

   // Update a HotelService
   @Transactional
   public HotelService updateHotelService(Long id, HotelService hotelServiceDetails) {
      HotelService oldHotelService = hotelServiceRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("HotelService not found with id: " + id));

      if (hotelServiceDetails.getName() != null) {
         oldHotelService.setName(hotelServiceDetails.getName());
      }
      if (hotelServiceDetails.getPrice() != null) {
         oldHotelService.setPrice(hotelServiceDetails.getPrice());
      }
      if (hotelServiceDetails.getDuration() != null) {
         oldHotelService.setDuration(hotelServiceDetails.getDuration());
      }
      // oldHotelService.setId(hotelServiceDetails.getId());
      return hotelServiceRepository.save(oldHotelService);
   }

   // Delete by id
   public void deleteHotelService(Long id) {
      hotelServiceRepository.deleteById(id);
   }

   // Provide HotelService to Room
   public void provideHotelServiceToRoom(Long hotelServiceId, Long roomId) {
      HotelService hotelService = hotelServiceRepository.findById(hotelServiceId)
            .orElseThrow(() -> new EntityNotFoundException("HotelService not found"));

      Room room = roomRepository.findById(roomId)
            .orElseThrow(() -> new EntityNotFoundException("Room not found"));

      // Check if the association already exists
      if (!hotelService.getRooms().contains(room)) {
         hotelService.getRooms().add(room);
         hotelServiceRepository.save(hotelService);
      }
   }

   public void removeHotelServiceFromRoom(Long hotelServiceId, Long roomId) {
      HotelService hotelService = hotelServiceRepository.findById(hotelServiceId)
            .orElseThrow(() -> new EntityNotFoundException("HotelService not found"));

      Room room = roomRepository.findById(roomId)
            .orElseThrow(() -> new EntityNotFoundException("Room not found"));

      if (hotelService.getRooms().contains(room)) {
         hotelService.getRooms().remove(room);
         hotelServiceRepository.save(hotelService);
      }
   }

   // public Set<HotelService> findByEmployees(Employee employee) {
   //    return hotelServiceRepository.findByEmployees(employee);
   // }

}