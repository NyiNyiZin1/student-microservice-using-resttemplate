package com.example.student.service.Impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.entity.Student;
import com.example.student.repositories.StudentRepository;
import com.example.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository studentRepo;

	@Override
	public String getStudent(Long studentId) {
		System.err.println("inservice impl>>>"+studentId);
		return studentRepo.getOne(studentId).toString();
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createStudent(Student student) {
		// TODO Auto-generated method stub
		studentRepo.save(student);
	}

}
