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

import com.example.demo.entity.HotelService;

import com.example.demo.service.HotelServiceService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/hotelservices")
public class HotelServiceController {

   @Autowired
   private HotelServiceService hotelServiceService;

   // POST -- Create a HotelService
   @Transactional
   @PostMapping()
   public HotelService createHotelService(@RequestBody HotelService hotelService) {
      return hotelServiceService.createHotelService(hotelService);
   }

   // GET -- Read ALL HotelServices
   @GetMapping()
   public List<HotelService> getAllHotelServices() {
      return hotelServiceService.getAllHotelServices();
   }

   // GET -- Read a HotelService by Id
   @GetMapping("/{id}")
   public HotelService getHotelServiceById(@PathVariable Long id) {
      return hotelServiceService.getHotelServiceById(id);
   }

   // GET 

   // PUT -- Update a HotelService
   @PutMapping("/{id}")
   public HotelService updateHotelService(@PathVariable Long id, @RequestBody HotelService hotelServiceDetails) {
      return hotelServiceService.updateHotelService(id, hotelServiceDetails);
   }

   // DELETE -- Delete a HotelService
   @DeleteMapping("/{id}")
   public void deleteHotelService(@PathVariable Long id) {
      hotelServiceService.deleteHotelService(id);
   }

   // POST -- Provide HotelService to Room

   @PostMapping("/providerooms")
   public void provideHotelServiceToRooms(@RequestBody Map<String, Long> hotelServiceRoomMapping) {

      Long hotelServiceId = hotelServiceRoomMapping.get("hotelServiceId");
      Long roomId = hotelServiceRoomMapping.get("roomId");

      hotelServiceService.provideHotelServiceToRoom(hotelServiceId, roomId);

   }

   // DELETE -- TEST METHOD:  Remove HotelService from a Room

   @DeleteMapping("/removeroom/{hotelServiceId}/{roomId}")
   public void removeHotelServiceFromRoom(@PathVariable Long hotelServiceId, @PathVariable Long roomId) {

      hotelServiceService.removeHotelServiceFromRoom(hotelServiceId, roomId);
   }

   // POST -- Provide HotelService to Room

   @PostMapping("/removeservicefromroom")
   public void removeHotelServiceToRoomss(@RequestBody Map<String, Long> hotelServiceRoomMapping) {

      Long hotelServiceId = hotelServiceRoomMapping.get("hotelServiceId");
      Long roomId = hotelServiceRoomMapping.get("roomId");

      hotelServiceService.removeHotelServiceFromRoom(hotelServiceId, roomId);
   }

   // @PostMapping("/providerooms")
   // public void provideHotelServiceToRooms(@RequestBody Map<String, ArrayList<Long>> hotelServiceRoomMapping) {
   //    Long hotelId = hotelServiceRoomMapping.get("hotelId").get(0);
   //    ArrayList<Long> roomIds = hotelServiceRoomMapping.get("roomId");

   //    for (Long roomId : roomIds) {
   //       hotelServiceService.provideHotelServiceToRoom(hotelId, roomId);    
   //    }
   // }

}
