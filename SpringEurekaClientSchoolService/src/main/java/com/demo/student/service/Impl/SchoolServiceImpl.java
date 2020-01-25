package com.demo.student.service.Impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.demo.student.entity.Student;
import com.demo.student.service.SchoolService;

@Service
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	RestTemplate restTemplate;

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getStudent(Long studentId){
	
		System.err.println("Consul Demo - Getting School details for " + studentId);
        String URL = "http://student-service/getStudentDetail/{studentId}";
        System.err.println("Response Received as "+URL);
        String response = restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, studentId).getBody();
        System.err.println("Response Received as ");

        return "School Name -  " + studentId + " :::  Student Details "+response ;
	}

	@Override
	public void createStudent(@Valid Student student) {
		// TODO Auto-generated method stub
		System.err.println("client1 >>>"+student.getClassName());
		restTemplate.exchange("http://student-service/createStudent/{student}", HttpMethod.POST, null, new ParameterizedTypeReference<String>() {
		},student).getBody();
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
