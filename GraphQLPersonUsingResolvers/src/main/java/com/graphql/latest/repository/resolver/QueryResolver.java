package com.graphql.latest.repository.resolver;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.latest.model.Person;
import com.graphql.latest.repository.IPersonRepository;
@Component
public class QueryResolver implements GraphQLQueryResolver {
	@Autowired
	private IPersonRepository personRepo;

	public QueryResolver(IPersonRepository personRepo) {
		this.personRepo = personRepo;
	}

	public List<Person> allPersons() {
		return personRepo.findAll();
	}

	public Optional<Person> personById(String id) {
		return personRepo.findById(id);
	}

}
