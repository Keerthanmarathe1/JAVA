package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    List<Employee> findByDesig(String desig);

    List<Employee> findBySalaryGreaterThan(double salary);

    List<Employee> findByNameContainingIgnoreCase(String name);
}
