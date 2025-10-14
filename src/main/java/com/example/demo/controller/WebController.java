//package com.example.demo.controller;
//
//import com.example.demo.repository.StudentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import com.example.demo.model.Student;
//
//
//@Controller
//public class WebController {
//
//    @Autowired
//    private StudentRepository studentRepository;
//
//    @GetMapping("/dashbord")
//    public String viewStudents(Model model) {
//        model.addAttribute("students", studentRepository.findAll());
//        return "students";  // returns students.html
//    }
//    
//    @GetMapping("/addstudent")
//    public String showForm(Model model) {
//    	model.addAttribute("student", new Student());
//    	return "addstudent";
//    }
//    
//    @PostMapping("/addstudent")
//    public String
//    saveStudent(@ModelAttribute("student") Student student){
//    	studentRepository.save(student);
//    	return "redirect:/viewstudent";
//    }
//    
// // Edit student
//    @GetMapping("/editstudent/{id}")
//    public String editStudent(@PathVariable String id, Model model) {
//        Student student = studentRepository.findById(id).orElse(null);
//        model.addAttribute("student", student);
//        return "editstudent";
//    }
//
//    // Update student
//    @PostMapping("/updatestudent")
//    public String updateStudent(@ModelAttribute("student") Student student) {
//        studentRepository.save(student);
//        return "redirect:/viewstudents";
//    }
//
//    // Delete student
//    @GetMapping("/deletestudent/{id}")
//    public String deleteStudent(@PathVariable String id) {
//        studentRepository.deleteById(id);
//        return "redirect:/viewstudents";
//    }
//
//}
