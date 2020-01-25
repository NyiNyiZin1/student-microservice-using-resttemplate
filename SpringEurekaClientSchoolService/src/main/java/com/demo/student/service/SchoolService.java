package com.demo.student.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.demo.student.entity.Student;


public interface SchoolService {
	
	String getStudent(@Valid Long studentId);
	List<Student> getAllStudent();
	void createStudent(Student student);
}
