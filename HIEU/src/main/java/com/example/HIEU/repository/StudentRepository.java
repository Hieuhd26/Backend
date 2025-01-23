package com.example.HIEU.repository;

import com.example.HIEU.entity.Student;
import com.example.HIEU.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,String> {
}
