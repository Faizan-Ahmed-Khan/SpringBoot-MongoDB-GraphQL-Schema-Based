package com.practice.graphql.schemabased.repository.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.graphql.schemabased.model.Person;
import com.practice.graphql.schemabased.repository.IPersonRepository;

@Service
public class PersonService {

	@Autowired
	private IPersonRepository personRepo;

	// Create Operation
	public Person create(String firstName, String lname, int age) {
		return personRepo.save(new Person(firstName, lname, age));
	}

	// Retrieve
	public List<Person> getAll() {
		return personRepo.findAll();
	}

	public Person getByfname(String firstName) {
		return personRepo.findByFirstName(firstName);
	}

	// Update
	public Person updatePerson(String firstName, String lname, int age) {
		Person p = personRepo.findByFirstName(firstName);
		p.setLname(lname);
		p.setAge(age);
		return personRepo.save(p);
	}

	// Delete
	public void deleteAll() {
		personRepo.deleteAll();
	}

	public void deleteByfname(String firstName) {
		Person p = personRepo.findByFirstName(firstName);
		personRepo.delete(p);
	}
}
