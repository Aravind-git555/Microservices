package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.main.model.Parent;
import com.main.model.Student;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class ServiceCalls {

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "fallbackParent", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50") })
	public Parent getParentById(int pid) {
		Parent parent = restTemplate.getForObject("http://parent-service/parent/" + pid, Parent.class);
		return parent;
	}

	@HystrixCommand(fallbackMethod = "fallbackStudent")
	public Student getStudentById(int id) {
		Student student = restTemplate.getForObject("http://student-service/student/" + id, Student.class);
		return student;
	}

	public Parent fallbackParent(int pid) {
		Parent p = new Parent();
		p.setRollno(0);
		p.setFather("not Found");
		p.setMother("not found");
		return p;
	}

	public Student fallbackStudent(int sid) {
		Student s = new Student();
		s.setRollno(0);
		s.setName("not found");
		s.setGrade(0);
		return s;
	}

}
