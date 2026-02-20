package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Employee;

public interface EmployeeService {

    // 1
    List<Employee> getAllEmployees();

    // 2
    Employee getEmployeeById(int id);

    // 3
    Employee addEmployee(Employee emp);

    // 4
    Employee updateEmployee(int id, Employee emp);

    // 5
    Employee patchEmployee(int id, Employee emp);

    // 6
    void deleteEmployee(int id);

    // 7
    void deleteAllEmployees();

    // 8
    long countEmployees();

    // 9
    boolean employeeExists(int id);

    // 10
    List<Employee> getByDepartment(String dept);

    // 11
    List<Employee> getBySalaryGreaterThan(double amount);

    // 12
    List<Employee> searchByName(String name);

    // 13
    List<Employee> addMultipleEmployees(List<Employee> employees);

    // 14
    Employee getHighestSalaryEmployee();

    // 15
    Employee getLowestSalaryEmployee();
}
