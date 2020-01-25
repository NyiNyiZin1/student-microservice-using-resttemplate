package com.example.student.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
