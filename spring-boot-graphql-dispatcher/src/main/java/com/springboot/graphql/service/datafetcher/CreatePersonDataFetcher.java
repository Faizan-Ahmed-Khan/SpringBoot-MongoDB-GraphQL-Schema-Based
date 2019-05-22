package com.springboot.graphql.service.datafetcher;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.graphql.model.Person;
import com.springboot.graphql.repository.IPersonRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

public class CreatePersonDataFetcher implements DataFetcher<Person> {

	@Autowired
	IPersonRepository personRepo;

	@Override
	public Person get(DataFetchingEnvironment environment) {
		Person p = environment.getSource();
		return personRepo.save(p);
	}

}
