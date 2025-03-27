package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.HotelService;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.HotelServiceRepository;

@Service
public class EmployeeService {

   @Autowired
   private EmployeeRepository employeeRepository;

   @Autowired
   private HotelServiceRepository hotelServiceRepository;

   // Create an Employee
   public Employee createEmployee(Employee thisEmployee) {
      return employeeRepository.save(thisEmployee);
   }

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

      oldEmployee.setName(employeeDetails.getName());
      oldEmployee.setInformation(employeeDetails.getInformation());
      oldEmployee.setRole(employeeDetails.getRole());

      return employeeRepository.save(oldEmployee);
   }

   // Associate an Employee with the HotelService he/she provides
   public void taskEmployeeWithHotelService(Long hotelServiceId, Long employeeId) {
      Employee thisEmployee = employeeRepository.findById(employeeId)
            .orElseThrow(() -> new RuntimeException("Employee not found"));
      HotelService thisHotelService = hotelServiceRepository.findById(hotelServiceId)
            .orElseThrow(() -> new RuntimeException("Hotel service not found"));

      if (!thisEmployee.getServices().contains(thisHotelService)) {
         thisEmployee.getServices().add(thisHotelService);
         employeeRepository.save(thisEmployee);
      }

   }

   // Delete an Employee
   public void deleteEmployee(Long id) {
      employeeRepository.deleteById(id);
   }

}
