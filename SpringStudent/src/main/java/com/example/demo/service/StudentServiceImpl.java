package com.example.demo.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo repo;

    // 1. Get all students
    @Override
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    // 2. Get student by ID
    @Override
    public Student getStudentById(int id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException("Student not found with id: " + id));
    }

    // 3. Add student
    @Override
    public Student addStudent(Student student) {
        return repo.save(student);
    }

    // 4. Update student (FULL)
    @Override
    public Student updateStudent(int id, Student student) {
        Student s = getStudentById(id);

        s.setName(student.getName());
        s.setAge(student.getAge());
        s.setCourse(student.getCourse());
        s.setFees(student.getFees());

        return repo.save(s);
    }

    // 5. Update student (PARTIAL)
    @Override
    public Student patchStudent(int id, Student student) {
        Student s = getStudentById(id);

        if (student.getName() != null)
            s.setName(student.getName());

        if (student.getAge() != 0)
            s.setAge(student.getAge());

        if (student.getFees() != 0)
            s.setFees(student.getFees());

        if (student.getCourse() != null)
            s.setCourse(student.getCourse());

        return repo.save(s);
    }

    // 6. Delete student by ID
    @Override
    public void deleteStudent(int id) {
        repo.delete(getStudentById(id));
    }

    // 7. Delete all students
    @Override
    public void deleteAllStudents() {
        repo.deleteAll();
    }

    // 8. Count students
    @Override
    public long countStudents() {
        return repo.count();
    }

    // 9. Check if student exists
    @Override
    public boolean studentExists(int id) {
        return repo.existsById(id);
    }

    // 10. Get students by course
    @Override
    public List<Student> getByCourse(String course) {
        return repo.findByCourse(course);
    }

    // 11. Get students by fees greater than
    @Override
    public List<Student> getByFeesGreaterThan(double amount) {
        return repo.findByFeesGreaterThan(amount);
    }

    // 12. Search students by name
    @Override
    public List<Student> searchByName(String name) {
        return repo.findByNameContainingIgnoreCase(name);
    }

    // 13. Add multiple students
    @Override
    public List<Student> addMultipleStudents(List<Student> students) {
        return repo.saveAll(students);
    }

    // 14. Get student with highest fees
    @Override
    public Student getHighestFeesStudent() {
        return repo.findAll().stream()
                .max(Comparator.comparingDouble(Student::getFees))
                .orElseThrow(() ->
                        new EmployeeNotFoundException("No students found"));
    }

    // 15. Get student with lowest fees
    @Override
    public Student getLowestFeesStudent() {
        return repo.findAll().stream()
                .min(Comparator.comparingDouble(Student::getFees))
                .orElseThrow(() ->
                        new EmployeeNotFoundException("No students found"));
    }
}
