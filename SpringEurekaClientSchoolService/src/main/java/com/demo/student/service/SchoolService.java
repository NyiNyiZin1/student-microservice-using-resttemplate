package com.demo.student.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.demo.student.entity.Student;


public interface SchoolService {
	
	Student getStudent(@Valid Long studentId);
	List<Student> getAllStudent();
	void createStudent(Student student);
	Student findByStudentId(@Valid Long studentId);
	void studentUpdate(Student student);
	void deleteStudent(@Valid Long id);
}
