package com.security.springboot.cruddemo.service;

import com.security.springboot.cruddemo.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

}
