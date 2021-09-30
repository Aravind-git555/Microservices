package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.main.model.Parent;
import com.main.model.ResponseObject;
import com.main.model.Student;

@RestController
@RequestMapping("/school")
public class SchoolController {

	@Autowired
	ServiceCalls service;

	@Autowired
	ResponseObject response;

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/{id}")
	public ResponseObject getStudentandParent(@PathVariable("id") int id) {
		
		Parent parent = service.getParentById(id);
		Student student = service.getStudentById(id);

		response.setId(id);
		response.setStudent(student.getName());
		response.setFather(parent.getFather());
		response.setMother(parent.getMother());
		return response;
	}

}
