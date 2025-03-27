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
public class Employee {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      private String name;

      private String information;

      private String role;

      @ManyToMany
      @JoinTable(
                  //
                  name = "employee_service",

                  joinColumns = @JoinColumn(name = "employee_id"),

                  inverseJoinColumns = @JoinColumn(name = "service_id")

      )

      private List<HotelService> services;

}
