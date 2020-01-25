package com.example.student.service;

import java.util.List;

import javax.validation.Valid;

import com.example.student.entity.Student;

public interface StudentService {
	
	String getStudent(@Valid Long studentId);
	List<Student> getAllStudent();
	void createStudent(Student student);

}
