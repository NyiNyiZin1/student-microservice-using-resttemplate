package com.demo.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	SchoolService studentService;
	
	@GetMapping(value = "/getStudentDetail/{studentId}")
	public ResponseEntity<Student> getStudent(@PathVariable Long studentId) {
		System.err.println("controller"+studentId);
//		Student student = schoolService.getStudent(studentId);
//		return student;
		return new ResponseEntity<Student>(studentService.getStudent(studentId),HttpStatus.OK);
	}
	
	//create holiday
		@PostMapping(value = "/createStudent")
	    public ResponseEntity<String> createStudent(@RequestBody Student student) throws Exception{
			System.err.println("a>>>"+student.getClassName());
			studentService.createStudent(student);
	        return new ResponseEntity<String>("Student Create Success...",HttpStatus.CREATED);
	    }
		
		@PutMapping(value = "/updateStudent/{studentId}")
		public ResponseEntity<String> updateStudent(@PathVariable Long studentId,@RequestBody Student student){
			
			/*if(studentService.getStudent(studentId) == null) {
				System.err.println("a>>>>>>>>>>>>>>>>"+studentId);
				return new ResponseEntity<String>("Student Not Found...",HttpStatus.NOT_FOUND);
			}else {*/
				System.err.println("ab>>>>>>>>>>>>>>>>"+studentId);
			studentService.studentUpdate(student);
			return new ResponseEntity<String>("Update Student...",HttpStatus.OK);
//			/}
		}
}
