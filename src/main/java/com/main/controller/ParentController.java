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

import com.main.entity.Parent;
import com.main.repository.ParentRepository;

@RestController
@RequestMapping("/parent")
public class ParentController {

	@Autowired
	ParentRepository repo;

	@PostMapping("/save")
	public void saveParent(@RequestBody Parent parent) {
		repo.save(parent);
		System.out.println("**Saved**");
	}

	@GetMapping("/{pid}")
	public Parent getParent(@PathVariable("pid") int pid) {
		Optional<Parent> p = repo.findById(pid);
		System.out.println(p.get().getRollno() + " " + p.get().getMother() + " " + p.get().getFather());
		return p.get();
	}
	
	@DeleteMapping("/delete/{pid}")
	public void deleteParent(@PathVariable("pid") int pid) {
		repo.deleteById(pid);
		System.out.println("**Deleted**");
	}
	
	@PutMapping("/update")
	public void update(@RequestBody Parent parent) {
		repo.save(parent);
		System.out.println("**Updated**");
	}
}
