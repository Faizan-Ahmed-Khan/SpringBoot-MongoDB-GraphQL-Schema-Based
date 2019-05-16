package com.practice.graphql.schemabased.repository.service.dataFetcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practice.graphql.schemabased.model.Person;
import com.practice.graphql.schemabased.repository.IPersonRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class PersonDataFetcher implements DataFetcher<Person> {

	@Autowired
	IPersonRepository personRepo;

	@Override
	public Person get(DataFetchingEnvironment environment) {
		String name = environment.getArgument("name");
		return personRepo.findByFirstName(name);
	}

}
