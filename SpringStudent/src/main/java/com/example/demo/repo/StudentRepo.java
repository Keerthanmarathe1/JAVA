package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

    List<Student> findByCourse(String course);

    List<Student> findByFeesGreaterThan(double fees);

    List<Student> findByNameContainingIgnoreCase(String name);
}
