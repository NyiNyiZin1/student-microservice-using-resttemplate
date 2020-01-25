package com.example.student.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.entity.Student;
import com.example.student.service.StudentService;
 
 
@RestController
public class StudentServiceController {
 
    private static Map<String, List<Student>> schooDB = new HashMap<String, List<Student>>();
    
    @Autowired
    StudentService studentService;
 
    static {
        schooDB = new HashMap<String, List<Student>>();
 
        List<Student> lst = new ArrayList<Student>();
        
        //Student std = new Student("Sajal", "Class IV");
       // lst.add(std);
       // std = new Student("Lokesh", "Class V");
     //   lst.add(std);
        //(1)create key,value school data
        schooDB.put("school1", lst);
 
        lst = new ArrayList<Student>();
        //std = new Student("Kajal", "Class III");
      //  lst.add(std);
       // std = new Student("Sukesh", "Class VI");
        //lst.add(std);
        //(2)create key,value school data
        schooDB.put("xyzschool", lst);
    }
 
    @RequestMapping(value = "/getAllStudentDetails/{schoolname}", method = RequestMethod.GET)
    public List<Student> getStudents(@PathVariable String schoolname) {
        System.err.println("Getting Student details for in studentService Controller>>>>" + schoolname);
        //get student data according to key name
        List<Student> studentList = schooDB.get(schoolname);
        if (studentList == null) {
            studentList = new ArrayList<Student>();
            //Student std = new Student("Not Found", "N/A");
      //      studentList.add(std);
        }
        return studentList;
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Student> getStudents2() {
        
        List<Student> studentList = schooDB.get("school1");
        if (studentList == null) {
            studentList = new ArrayList<Student>();
           // Student std = new Student("Not Found", "N/A");
      //      studentList.add(std);
        }
        return studentList;
    }
    
    @GetMapping("/getStudentDetail/{studentId}")
    public String getStudent(@PathVariable Long studentId) {
    	System.err.println("service Id>>>>>"+studentId);
    	return studentService.getStudent(studentId);
    	
    }
    
    @PostMapping("/createStudent/{student}")
    public void createStudent(@PathParam(value = "student") Student student) {
    	System.err.println("server1 >>>"+student.getClassName());
    	studentService.createStudent(student);
    	
    }
    
}