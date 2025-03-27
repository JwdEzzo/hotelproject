package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.UniqueConstraint;
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
                  name = "room_service", //
                  joinColumns = @JoinColumn(name = "service_id"), //
                  inverseJoinColumns = @JoinColumn(name = "room_id")//
      /**/ )
      @JsonIgnore
      private List<Room> rooms;

      @ManyToMany(mappedBy = "services", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
      @JsonIgnore
      private List<Employee> employees;
}
