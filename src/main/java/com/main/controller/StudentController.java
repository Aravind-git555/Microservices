package com.main.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.Repository.StudentRepo;
import com.main.entity.Student;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentRepo repo;

	@PostMapping("/save")
	public void saveStuden(@RequestBody Student student) {
		repo.save(student);
	}

	@GetMapping("/{sid}")
	public Student getStudent(@PathVariable("sid") int sid) {
		Optional<Student> stu = repo.findById(sid);
		System.out.println(stu.get());
		return stu.get();
	}

	@DeleteMapping("/delete/{sid}")
	public void deleteSid(@PathVariable("sid") int sid) {
		repo.deleteById(sid);
	}

	@PutMapping("/update")
	public void updateStudent(@RequestBody Student student) {
		repo.save(student);
	}

}
