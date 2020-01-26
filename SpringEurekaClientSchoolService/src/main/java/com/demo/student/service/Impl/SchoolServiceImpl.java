package com.demo.student.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
	
	String GET_STU_URL = "http://student-service";
	//String GET_STU_URL = "http://localhost:9098";
	
	@Value("${studentservice.application.name}")
	//private String GET_STU_URL;

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getStudent(Long studentId){
        //String URL = "http://student-service/getStudentDetail/{studentId}";
		String URL = GET_STU_URL+"/getStudentDetail/"+studentId;
        //String response = restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, studentId).getBody();
       

        Student student = restTemplate.getForObject(URL,Student.class);
        
        
        
        return student ;
	}

	@Override
	public void createStudent(@Valid Student student) {
		// TODO Auto-generated method stub
		String URL = GET_STU_URL+"/createStudent";
		System.err.println("client1 >>>"+student.getClassName());
		restTemplate.postForObject(URL, student, Student.class);
	}
	
	@Override
	public Student findByStudentId(@Valid Long studentId) {
		// TODO Auto-generated method stub
		String URL = GET_STU_URL+"/getStudentDetail/"+studentId;
		Student student = restTemplate.getForObject(URL,Student.class);
		return student;
	}

	@Override
	public void studentUpdate(@Valid Student student) {
		// TODO Auto-generated method stub
		System.err.println(">>>>>>>fdfdf>>>>>>>>>"+student.getClassName());
		Map < String, String > params = new HashMap < String, String > ();
        params.put("id", "1");
		String URL = GET_STU_URL+"/updateStudent";
		//Student student1 = restTemplate.exchange(URL, HttpMethod.PUT, student, Student.class);
		restTemplate.put(URL, student, params);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	
	
}
