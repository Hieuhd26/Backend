package com.example.demo.repo.custome;

import com.example.demo.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class StudentRepositoryCustomImpl implements StudentRepositoryCustom {
    EntityManager em;

    @Override
    public List<Student> findStudentByNameAndAge(String name, int age) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        Root<Student> student = cq.from(Student.class);
        Predicate agePredicate = cb.equal(student.get("age"), age);
        Predicate namePredicate = cb.like(student.get("name"), "%" + name + "%");
        cq.where(agePredicate, namePredicate);
        TypedQuery<Student> query = em.createQuery(cq);

        return query.getResultList();
    }
}
