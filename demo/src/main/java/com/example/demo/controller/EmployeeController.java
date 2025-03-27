package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

   @Autowired
   private EmployeeService employeeService;

   // POST -- Create a Booking
   @PostMapping()
   public Employee createEmployee(@RequestBody Employee employee) {
      return employeeService.createEmployee(employee);
   }

   // GET -- Read ALL Bookings
   @GetMapping()
   public List<Employee> getAllEmployees() {
      return employeeService.getAllEmployees();
   }

   // GET -- Read a Booking by Id
   @GetMapping("/{id}")
   public Employee getEmployeeById(@PathVariable Long id) {
      return employeeService.getEmployeeById(id);
   }

   // PUT -- Update a Booking
   @PutMapping("/{id}")
   public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
      return employeeService.updateEmployee(id, employeeDetails);
   }

   // DELETE -- Delete a Booking
   @DeleteMapping("/{id}")
   public void deleteEmployee(@PathVariable Long id) {
      employeeService.deleteEmployee(id);
   }
   
   // POST -- Task an Employee with a HotelService
   @PostMapping("/taskwithservice")
   public void taskEmployeeWithHotelService(@RequestBody Map<String,Long> employeeServiceMap) {
       
      Long employeeId = employeeServiceMap.get("employeeId");
      Long hotelServiceId = employeeServiceMap.get("hotelId");

      employeeService.taskEmployeeWithHotelService(hotelServiceId, employeeId);
      
   }
    

}
