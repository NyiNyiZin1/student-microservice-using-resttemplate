package com.example.student.service;

import java.util.List;

import javax.validation.Valid;

import com.example.student.entity.Student;

public interface StudentService {
	
	Student getStudent(@Valid Long studentId);
	List<Student> getAllStudent();
	void createStudent(@Valid Student student);
	void studentUpdate(Student student);
}
