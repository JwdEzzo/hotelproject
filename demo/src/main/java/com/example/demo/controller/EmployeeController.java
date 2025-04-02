package com.example.demo.controller;

import java.util.List;
import java.util.Set;

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
import com.example.demo.enums.EmployeeRole;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

   @Autowired
   private EmployeeService employeeService;

   // POST -- Create a Employee
   @PostMapping()
   public Employee createEmployee(@RequestBody Employee employee) {
      return employeeService.createEmployee(employee);
   }

   // GET -- Read ALL Employees
   @GetMapping()
   public List<Employee> getAllEmployees() {
      return employeeService.getAllEmployees();
   }

   // GET -- Read an Employee by first name
   @GetMapping("/firstname/{firstName}")
   public List<Employee> getEmployeeByFirstName(@PathVariable String firstName) {
      return employeeService.findEmployeeByFirstName(firstName);
   }

   // GET -- Read a Employee by last name
   @GetMapping("/lastname/{lastName}")
   public List<Employee> getEmployeeByLastName(@PathVariable String lastName) {
      return employeeService.findEmployeeByLastName(lastName);
   }

   // GET -- Read an Employee by first name and last name
   @GetMapping("/name/{firstName}/{lastName}")
   public Employee getEmployeeByName(@PathVariable String firstName, @PathVariable String lastName) {
      return employeeService.findEmployeeByName(firstName, lastName);
   }

   // GET -- Read an Employee By Email
   @GetMapping("/email/{email}")
   public Employee getEmployeeByEmail(@PathVariable String email) {
      return employeeService.findEmployeeByEmail(email);
   }

   // GET -- Read Employees By Role
   @GetMapping("/role/{employeeRole}")
   public Set<Employee> getEmployeesByRole(@PathVariable EmployeeRole employeeRole) {
      return employeeService.findByRole(employeeRole);
   }

   // GET -- Read a Employee by Id
   @GetMapping("/{id}")
   public Employee getEmployeeById(@PathVariable Long id) {
      return employeeService.getEmployeeById(id);
   }

   // PUT -- Update an Employee
   @PutMapping("/{id}")
   public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
      return employeeService.updateEmployee(id, employeeDetails);
   }

   // DELETE -- Delete an Employee
   @DeleteMapping("/{id}")
   public void deleteEmployee(@PathVariable Long id) {
      employeeService.deleteEmployee(id);
   }

   // // GET -- Read Employees by Services
   // @GetMapping("/hotelService/{hotelService}")
   // public Set<Employee> getEmployeesByService(@PathVariable HotelService hotelService) {
   //    return employeeService.findEmployeesByService(hotelService);
   // }

   // // POST -- Task an Employee with a HotelService
   // @PostMapping("/taskwithservice")
   // public void taskEmployeeWithHotelService(@RequestBody Map<String, Long> employeeServiceMap) {

   //    Long employeeId = employeeServiceMap.get("employeeId");
   //    Long hotelServiceId = employeeServiceMap.get("hotelId");

   //    employeeService.taskEmployeeWithHotelService(hotelServiceId, employeeId);

   // }

}
