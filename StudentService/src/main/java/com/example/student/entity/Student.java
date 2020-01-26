package com.example.student.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Student
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String name;
    private String className;
    
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
 
    
}
