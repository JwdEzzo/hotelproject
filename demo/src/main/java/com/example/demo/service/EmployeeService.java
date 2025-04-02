package com.example.demo.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.enums.EmployeeRole;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

   @Autowired
   private EmployeeRepository employeeRepository;

   // Create an Employee
   public Employee createEmployee(Employee thisEmployee) {
      return employeeRepository.save(thisEmployee);
   }

   // Find by Email
   public Employee findEmployeeByEmail(String email) {
      return employeeRepository.findEmployeeByEmail(email);
   }

   // Find by First Name
   public List<Employee> findEmployeeByFirstName(String firstName) {
      return employeeRepository.findEmployeeByFirstName(firstName);
   }

   // Find by Last Name
   public List<Employee> findEmployeeByLastName(String lastName) {
      return employeeRepository.findEmployeeByLastName(lastName);
   }

   // Find by First Name and Last Name
   public Employee findEmployeeByName(String firstName, String lastName) {
      return employeeRepository.findEmployeeByName(firstName, lastName);
   }

   // Find all by Type
   public Set<Employee> findByRole(EmployeeRole role) {
      return employeeRepository.findEmployeeByRole(role);
   }

   // // Find Employee by Services
   // public Set<Employee> findEmployeesByService(HotelService hotelService) {
   //    return employeeRepository.findEmployeesByService(hotelService);
   // }

   // Read ALL Employees
   public List<Employee> getAllEmployees() {
      return employeeRepository.findAll();
   }

   // Read an Employee by Id
   public Employee getEmployeeById(Long id) {
      return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
   }

   // Update an Employee
   public Employee updateEmployee(Long id, Employee employeeDetails) {
      Employee oldEmployee = employeeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Employee not found"));

      oldEmployee.setFirstName(employeeDetails.getFirstName());
      oldEmployee.setLastName(employeeDetails.getLastName());
      oldEmployee.setEmail(employeeDetails.getEmail());
      oldEmployee.setRole(employeeDetails.getRole());

      return employeeRepository.save(oldEmployee);
   }

   // // Associate an Employee with the HotelService he/she provides
   // public void taskEmployeeWithHotelService(Long hotelServiceId, Long employeeId) {
   //    Employee thisEmployee = employeeRepository.findById(employeeId)
   //          .orElseThrow(() -> new RuntimeException("Employee not found"));
   //    HotelService thisHotelService = hotelServiceRepository.findById(hotelServiceId)
   //          .orElseThrow(() -> new RuntimeException("Hotel service not found"));

   //    if (!thisEmployee.getServices().contains(thisHotelService)) {
   //       thisEmployee.getServices().add(thisHotelService);
   //       employeeRepository.save(thisEmployee);
   //    }

   // }

   // Delete an Employee
   public void deleteEmployee(Long id) {
      employeeRepository.deleteById(id);
   }

}
