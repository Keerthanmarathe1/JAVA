package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private EmployeeService service;

    // 1. Get all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    // 2. Get employee by ID
    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return service.getEmployeeById(id);
    }

    // 3. Add employee
    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee emp) {
        return service.addEmployee(emp);
    }

    // 4. Update employee (full)
    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable int id,
                                   @RequestBody Employee emp) {
        return service.updateEmployee(id, emp);
    }

    // 5. Update employee (partial)
    @PatchMapping("/employee/{id}")
    public Employee patchEmployee(@PathVariable int id,
                                  @RequestBody Employee emp) {
        return service.patchEmployee(id, emp);
    }

    // 6. Delete employee by ID
    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        service.deleteEmployee(id);
        return "Employee deleted successfully";
    }

    // 7. Delete all employees
    @DeleteMapping("/employees")
    public String deleteAllEmployees() {
        service.deleteAllEmployees();
        return "All employees deleted successfully";
    }

    // 8. Count employees
    @GetMapping("/employees/count")
    public long countEmployees() {
        return service.countEmployees();
    }

    // 9. Check if employee exists
    @GetMapping("/employee/{id}/exists")
    public boolean employeeExists(@PathVariable int id) {
        return service.employeeExists(id);
    }

    // 10. Get employees by department
    @GetMapping("/employees/department/{dept}")
    public List<Employee> getByDepartment(@PathVariable String dept) {
        return service.getByDepartment(dept);
    }

    // 11. Get employees by salary greater than
    @GetMapping("/employees/salary/{amount}")
    public List<Employee> getBySalaryGreaterThan(@PathVariable double amount) {
        return service.getBySalaryGreaterThan(amount);
    }

    // 12. Search employee by name
    @GetMapping("/employees/search/{name}")
    public List<Employee> searchByName(@PathVariable String name) {
        return service.searchByName(name);
    }

    // 13. Add multiple employees
    @PostMapping("/employees")
    public List<Employee> addMultipleEmployees(@RequestBody List<Employee> employees) {
        return service.addMultipleEmployees(employees);
    }

    // 14. Get employee with highest salary
    @GetMapping("/employee/highest-salary")
    public Employee getHighestSalaryEmployee() {
        return service.getHighestSalaryEmployee();
    }

    // 15. Get employee with lowest salary
    @GetMapping("/employee/lowest-salary")
    public Employee getLowestSalaryEmployee() {
        return service.getLowestSalaryEmployee();
    }
}
