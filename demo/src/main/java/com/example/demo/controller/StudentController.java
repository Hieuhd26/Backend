package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/all")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping()
    public List<Student> getAll() {
        return studentService.findAllStudent();
    }

    @GetMapping("/{name}")
    public List<Student> getAll(@PathVariable String name) {
        return studentService.findAllStudentWithName(name);
    }
}
