package com.example.demo.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo repo;

    @Override
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(
                        "Employee not found with id: " + id));
    }

    @Override
    public Employee addEmployee(Employee emp) {
        return repo.save(emp);
    }

    @Override
    public Employee updateEmployee(int id, Employee emp) {
        Employee e = getEmployeeById(id);

        e.setName(emp.getName());
        e.setAge(emp.getAge());
        e.setSalary(emp.getSalary());
        e.setDesig(emp.getDesig());

        return repo.save(e);
    }

    @Override
    public Employee patchEmployee(int id, Employee emp) {
        Employee e = getEmployeeById(id);

        if (emp.getName() != null)
            e.setName(emp.getName());

        if (emp.getAge() != 0)
            e.setAge(emp.getAge());

        if (emp.getSalary() != 0)
            e.setSalary(emp.getSalary());

        if (emp.getDesig() != null)
            e.setDesig(emp.getDesig());

        return repo.save(e);
    }

    @Override
    public void deleteEmployee(int id) {
        Employee e = getEmployeeById(id);
        repo.delete(e);
    }

    @Override
    public void deleteAllEmployees() {
        repo.deleteAll();
    }

    // ----------- NEW METHODS -----------

    @Override
    public long countEmployees() {
        return repo.count();
    }

    @Override
    public boolean employeeExists(int id) {
        return repo.existsById(id);
    }

    @Override
    public List<Employee> getByDepartment(String dept) {
        return repo.findByDesig(dept);
    }

    @Override
    public List<Employee> getBySalaryGreaterThan(double amount) {
        return repo.findBySalaryGreaterThan(amount);
    }

    @Override
    public List<Employee> searchByName(String name) {
        return repo.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Employee> addMultipleEmployees(List<Employee> employees) {
        return repo.saveAll(employees);
    }

    @Override
    public Employee getHighestSalaryEmployee() {
        return repo.findAll().stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("No employees found"));
    }

    @Override
    public Employee getLowestSalaryEmployee() {
        return repo.findAll().stream()
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("No employees found"));
    }
}
