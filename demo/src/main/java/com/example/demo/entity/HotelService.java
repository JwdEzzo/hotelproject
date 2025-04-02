package com.example.demo.entity;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class HotelService {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      private String name;

      private Double price;

      private String duration;

      @ManyToMany
      @JoinTable( //
                  name = "room_hotelService", //
                  joinColumns = @JoinColumn(name = "hotelService_id"), //
                  inverseJoinColumns = @JoinColumn(name = "room_id")//
      /**/ )
      private List<Room> rooms;

      // @ManyToMany(mappedBy = "services", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })

      // private Set<Employee> employees;
}
