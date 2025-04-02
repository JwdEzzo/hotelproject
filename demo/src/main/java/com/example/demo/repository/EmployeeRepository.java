package com.example.demo.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Employee;

import com.example.demo.enums.EmployeeRole;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

   // Find by First Name
   @Query("SELECT e FROM Employee e WHERE e.firstName = ?1")
   public List<Employee> findEmployeeByFirstName(String firstName);

   // Find by Last Name
   @Query("SELECT e FROM Employee e WHERE e.lastName = ?1")
   public List<Employee> findEmployeeByLastName(String lastName);

   // Find by First Name and Last Name
   @Query("SELECT e FROM Employee e WHERE e.firstName = ?1 and e.lastName = ?2")
   public Employee findEmployeeByName(String firstName, String lastName);

   // Find all by Type
   @Query("SELECT e FROM Employee e WHERE e.role = ?1")
   public Set<Employee> findEmployeeByRole(EmployeeRole role);

   // Find By Email
   @Query("SELECT e FROM Employee e WHERE e.email = ?1")
   public Employee findEmployeeByEmail(String email);

   //    // Find Employee by Services
   //    @Query("SELECT e FROM Employee e JOIN e.services s WHERE s = ?1")
   //    public Set<Employee> findEmployeesByService(HotelService hotelService);

   //    // // This method lets JPA handle the query based on the naming of the method
   //    // public Set<Employee> findByServices(HotelService hotelService);
   // }
}
