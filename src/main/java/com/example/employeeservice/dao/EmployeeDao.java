package com.example.employeeservice.dao;

import com.example.employeeservice.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends MongoRepository<Employee,String> {
}
