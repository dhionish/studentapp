package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    // Add student
    public Student addStudent(Student student) {
        return repo.save(student);
    }

    // Get all students
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    // Update student
    public Student updateStudent(String id, Student studentDetails) {
        Student student = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        student.setName(studentDetails.getName());
        student.setAge(studentDetails.getAge());
        student.setCourse(studentDetails.getCourse());

        return repo.save(student);
    }

    // Delete student
    public void deleteStudent(String id) {
        repo.deleteById(id);
    }
}
