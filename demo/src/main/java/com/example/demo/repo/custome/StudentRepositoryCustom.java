package com.example.demo.repo.custome;

import com.example.demo.model.Student;

import java.util.List;

public interface StudentRepositoryCustom {
    List<Student> findStudentByNameAndAge(String name, int age);
}
