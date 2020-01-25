package com.demo.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.student.entity.Student;
import com.demo.student.service.SchoolService;

@RestController
public class SchoolServiceController {
	/*
	 * @Autowired RestTemplate restTemplate;
	 * 
	 * @RequestMapping(value = "/getSchoolDetails/{schoolname}", method =
	 * RequestMethod.GET) public String getStudents(@PathVariable String schoolname)
	 * {
	 * 
	 * String response = restTemplate.exchange(
	 * "http://student-service/getStudentDetails/{schoolname}", HttpMethod.GET,
	 * null, new ParameterizedTypeReference<String>() { }, schoolname).getBody();
	 * 
	 * return "School Namee : " + schoolname + " \n Student Details " + response; }
	 */
	
	@Autowired
	SchoolService schoolService;
	
	@GetMapping(value = "/getStudentDetail/{studentId}")
	public String getStudent(@PathVariable Long studentId) {
		
		String student = schoolService.getStudent(studentId);
		return student;
		
	}
	
	//create holiday
		@PostMapping(value = "/createStudent")
	    public String createStudent(@RequestBody Student student) throws Exception{
			
			schoolService.createStudent(student);
	        return "Create Success...";
	    }

	
}
