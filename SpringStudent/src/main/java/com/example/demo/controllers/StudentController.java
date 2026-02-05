package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService service;

    // 1. Get all students
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    // 2. Get student by ID
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable int id) {
        return service.getStudentById(id);
    }

    // 3. Add student
    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student) {
        return service.addStudent(student);
    }

    // 4. Update student (full)
    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable int id,
                                 @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    // 5. Update student (partial)
    @PatchMapping("/student/{id}")
    public Student patchStudent(@PathVariable int id,
                                @RequestBody Student student) {
        return service.patchStudent(id, student);
    }

    // 6. Delete student by ID
    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
        return "Student deleted successfully";
    }

    // 7. Delete all students
    @DeleteMapping("/students")
    public String deleteAllStudents() {
        service.deleteAllStudents();
        return "All students deleted successfully";
    }

    // 8. Count students
    @GetMapping("/students/count")
    public long countStudents() {
        return service.countStudents();
    }

    // 9. Check if student exists
    @GetMapping("/student/{id}/exists")
    public boolean studentExists(@PathVariable int id) {
        return service.studentExists(id);
    }

    // 10. Get students by course
    @GetMapping("/students/course/{course}")
    public List<Student> getByCourse(@PathVariable String course) {
        return service.getByCourse(course);
    }

    // 11. Get students by fees greater than
    @GetMapping("/students/fees/{amount}")
    public List<Student> getByFeesGreaterThan(@PathVariable double amount) {
        return service.getByFeesGreaterThan(amount);
    }

    // 12. Search student by name
    @GetMapping("/students/search/{name}")
    public List<Student> searchByName(@PathVariable String name) {
        return service.searchByName(name);
    }

    // 13. Add multiple students
    @PostMapping("/students/bulk")
    public List<Student> addMultipleStudents(@RequestBody List<Student> students) {
        return service.addMultipleStudents(students);
    }

    // 14. Get student with highest fees
    @GetMapping("/student/highest-fees")
    public Student getHighestFeesStudent() {
        return service.getHighestFeesStudent();
    }

    // 15. Get student with lowest fees
    @GetMapping("/student/lowest-fees")
    public Student getLowestFeesStudent() {
        return service.getLowestFeesStudent();
    }
}
