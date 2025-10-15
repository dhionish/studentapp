package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // 🟢 View all students
    @GetMapping("/viewstudents")
    public String viewStudents(@RequestParam(required = false) String keyword, Model model,String course) {
        List<Student> students= studentRepository.findAll();
        if (keyword != null && !keyword.isEmpty()) {
            students = students.stream()
                .filter(s -> s.getName().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
        } 
        
        if (course != null && !course.isEmpty()) {
            students = students.stream()
                .filter(s -> s.getCourse().equalsIgnoreCase(course))
                .toList();
        } 
        
        model.addAttribute("students", students);
        model.addAttribute("keyword", keyword);
        model.addAttribute("course", course);
        return "students";
    }

    // 🟢 Show add student form
    @GetMapping("/addstudent")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        return "addstudent"; // addstudent.html
    }

    // 🟢 Add student
    @PostMapping("/addstudent")
    public String addStudent(@ModelAttribute Student student, RedirectAttributes redirectAttributes) {
        studentRepository.save(student);
        redirectAttributes.addFlashAttribute("message", "Student added successfully!");
        redirectAttributes.addFlashAttribute("msgType", "success");
        return "redirect:/viewstudents";
    }

    // 🟡 Show edit form
    @GetMapping("/editstudent/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        Student student = studentRepository.findById(id).orElse(null);
        model.addAttribute("student", student);
        return "editstudent"; // editstudent.html
    }

    // 🟡 Update student
    @PostMapping("/updatestudent")
    public String updateStudent(@ModelAttribute Student student, RedirectAttributes redirectAttributes) {
        studentRepository.save(student);
        redirectAttributes.addFlashAttribute("message", "Student updated successfully!");
        redirectAttributes.addFlashAttribute("msgType", "info");
        return "redirect:/viewstudents";
    }

    // 🔴 Delete student
    @GetMapping("/deletestudent/{id}")
    public String deleteStudent(@PathVariable String id, RedirectAttributes redirectAttributes) {
        studentRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Student deleted successfully!");
        redirectAttributes.addFlashAttribute("msgType", "danger");
        return "redirect:/viewstudents";
    }
}