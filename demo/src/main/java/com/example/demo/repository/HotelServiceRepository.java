package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.HotelService;

public interface HotelServiceRepository extends JpaRepository<HotelService, Long> {

}
