package com.springboot.graphql.service.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.graphql.model.Person;
import com.springboot.graphql.repository.IPersonRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllPersonsDataFetcher implements DataFetcher<List<Person>> {

	@Autowired
	IPersonRepository personRepo;

	@Override
	public List<Person> get(DataFetchingEnvironment environment) {
		return personRepo.findAll();
	}

}
