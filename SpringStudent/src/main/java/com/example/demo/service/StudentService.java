package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Student;

public interface StudentService {

    List<Student> getAllStudents();

    Student getStudentById(int id);

    Student addStudent(Student student);

    Student updateStudent(int id, Student student);

    Student patchStudent(int id, Student student);

    void deleteStudent(int id);

    void deleteAllStudents();

    long countStudents();

    boolean studentExists(int id);

    List<Student> getByCourse(String course);

    List<Student> getByFeesGreaterThan(double amount);

    List<Student> searchByName(String name);

    List<Student> addMultipleStudents(List<Student> students);

    Student getHighestFeesStudent();

    Student getLowestFeesStudent();
}
