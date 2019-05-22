package com.springboot.graphql.service.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.graphql.model.Person;
import com.springboot.graphql.repository.IPersonRepository;

import graphql.schema.DataFetcher;

@Component
public class PersonsDataFetcher {

	@Autowired
	IPersonRepository personRepo;

	public DataFetcher<List<Person>> getAllPerson() {
		return dataFetchingEnvironment -> {
			return personRepo.findAll();
		};
	}

	public DataFetcher<Person> getPersonByFirstName() {
		return dataFetchingEnvironment -> {
			return personRepo.findByFirstName(dataFetchingEnvironment.getArgument("firstName"));
		};
	}

	public DataFetcher<Person> createNewPerson() {
		return dataFetchingEnvironment -> {
			return personRepo.save(new Person(dataFetchingEnvironment.getArgument("id"),
					dataFetchingEnvironment.getArgument("firstName"), dataFetchingEnvironment.getArgument("lname"),
					dataFetchingEnvironment.getArgument("age")));
		};
	}

}
