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
	public Student getStudent(Long studentId) {
		System.err.println("inservice impll>>>"+studentId);
		return studentRepo.getOne(studentId);
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

	@Override
	public void studentUpdate(Student student) {
		// TODO Auto-generated method stub
		Student student1 = studentRepo.getOne(student.getId());
		student1.setClassName(student.getClassName());
		student1.setName(student.getName());
		studentRepo.saveAndFlush(student1);
		}
		
	}


