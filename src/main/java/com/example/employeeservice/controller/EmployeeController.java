package com.example.employeeservice.controller;

import com.example.employeeservice.model.Employee;
import com.example.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    private EmployeeService employeeService;
    private Environment environment;
    @Autowired
    public EmployeeController(EmployeeService employeeService, Environment environment) {
        this.employeeService = employeeService;
        this.environment = environment;
    }
    @GetMapping
    public ResponseEntity<String> getStatus()
    {
        return ResponseEntity.ok("up and running on port: "+environment.getProperty("local.server.port"));
    }
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployee()
    {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }
    @PostMapping("/employees")
    public ResponseEntity<Employee> createCustomer(@RequestBody Employee employee)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employee));
    }
}
