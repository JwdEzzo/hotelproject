package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Room;
import com.example.demo.enums.RoomStatus;
import com.example.demo.enums.RoomType;

public interface RoomRepository extends JpaRepository<Room, Long> {

      public Room findByRoomNumber(String roomNumber);

      public List<Room> findByRoomType(RoomType roomType);

      @Query("SELECT r FROM Room r WHERE r.id NOT IN " +
                  "(SELECT b.room.id FROM Booking b WHERE " +
                  "(b.checkInDateTime < :checkOut AND b.checkOutDateTime > :checkIn))")
      List<Room> findAvailableRooms(LocalDateTime checkIn, LocalDateTime checkOut);

      public List<Room> findByRoomStatus(RoomStatus roomStatus);

}
