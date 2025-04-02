package com.example.demo.entity;

import com.example.demo.enums.EmployeeRole;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employee {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      private String firstName;

      private String lastName;

      private String email;

      @Enumerated(EnumType.STRING)
      private EmployeeRole role;

      // @ManyToMany
      // @JoinTable(
      //             //
      //             name = "employee_hotelService",

      //             joinColumns = @JoinColumn(name = "employee_id"),

      //             inverseJoinColumns = @JoinColumn(name = "hotelService_id")

      // )

      // private Set<HotelService> services;

}
