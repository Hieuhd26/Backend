package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.repo.StudentRepository.hasName;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    public List<Student> findAllStudentWithName(String name) {
        return studentRepository.findAll(hasName(name));
    }
}
