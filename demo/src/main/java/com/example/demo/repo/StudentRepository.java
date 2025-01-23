package com.example.demo.repo;

import com.example.demo.model.Student;
import com.example.demo.repo.custome.StudentRepositoryCustom;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>
        // , StudentRepositoryCustom
        , JpaSpecificationExecutor<Student> {
    static Specification<Student> hasName(String name) {
        return (student, cq, cb) -> cb.equal(student.get("name"), name);
    }

    static Specification<Student> emailContains(String email) {
        return (student, cq, cb) -> cb.like(student.get("email"), "%" + email + "%");
    }
}
