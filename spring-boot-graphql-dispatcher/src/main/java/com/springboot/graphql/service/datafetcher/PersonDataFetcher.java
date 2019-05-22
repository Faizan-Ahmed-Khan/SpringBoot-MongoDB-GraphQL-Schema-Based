package com.springboot.graphql.service.datafetcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.graphql.model.Person;
import com.springboot.graphql.repository.IPersonRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class PersonDataFetcher implements DataFetcher<Person> {

	@Autowired
	IPersonRepository personRepo;

	@Override
	public Person get(DataFetchingEnvironment environment) {
		String firstName = environment.getArgument("firstName");
		return personRepo.findByFirstName(firstName);
	}

}
