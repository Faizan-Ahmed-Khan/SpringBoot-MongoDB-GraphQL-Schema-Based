package com.practice.graphql.schemabased.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.graphql.schemabased.model.Person;
import com.practice.graphql.schemabased.repository.service.PersonService;

@RestController
public class PersonControllerRest {

	@Autowired
	private PersonService service;

//Create
	@PostMapping("/person/{firstName}/{lname}/{age}")
	public String insertPerson(@PathVariable("firstName") String firstName, @PathVariable String lname,
			@PathVariable int age) {
		Person p = service.create(firstName, lname, age);
		return p.toString();
	}

//Retrieve
	@GetMapping("/person")
	public List<Person> getAllPerson() {
		return service.getAll();
	}

	@GetMapping("/person/{firstName}")
	public String getPersonByfirstName(@PathVariable("firstName") String firstName) {
		Person p = service.getByfname(firstName);
		return p.toString();
	}

//Update
	@PutMapping("/person/{firstName}/{lname}/{age}")
	public String updatePerson(@PathVariable("firstName") String firstName, @PathVariable String lname,
			@PathVariable int age) {
		Person p = service.updatePerson(firstName, lname, age);
		return p.toString();
	}

//Delete
	@DeleteMapping("/person")
	public void deleteAll() {
		service.deleteAll();
	}

	@DeleteMapping("/person/{firstName}")
	public void deleteByFname(@PathVariable("firstName") String firstName) {
		service.deleteByfname(firstName);
	}

}
