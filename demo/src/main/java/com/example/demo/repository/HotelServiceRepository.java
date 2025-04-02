package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.HotelService;

public interface HotelServiceRepository extends JpaRepository<HotelService, Long> {

   // // Find Services by Employee (JPQL)
   // @Query("SELECT s FROM HotelService s WHERE :employee MEMBER OF s.employees")
   // Set<HotelService> findServicesByEmployee(@Param("employee") Employee employee);
}
