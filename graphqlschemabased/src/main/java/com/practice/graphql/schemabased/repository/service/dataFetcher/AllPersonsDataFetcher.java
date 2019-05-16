package com.practice.graphql.schemabased.repository.service.dataFetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practice.graphql.schemabased.model.Person;
import com.practice.graphql.schemabased.repository.IPersonRepository;

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
