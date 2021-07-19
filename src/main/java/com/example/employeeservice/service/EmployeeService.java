package com.example.employeeservice.service;

import com.example.employeeservice.model.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee createEmployee(Employee employee);
    public List<Employee> getAllEmployees();
}
