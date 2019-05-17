package com.graphql.latest.repository.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.latest.model.Person;
import com.graphql.latest.repository.IPersonRepository;

@Component
public class MutationResolver implements GraphQLMutationResolver {

	@Autowired
	private IPersonRepository personRepo;

	public MutationResolver(IPersonRepository personRepo) {
		this.personRepo = personRepo;
	}

	public Person newPerson(String id, String name, String age) {
		return personRepo.save(new Person(id, name, age));
	}
}
