package com.practice.graphql.schemabased.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.practice.graphql.schemabased.model.Person;

@Repository
public interface IPersonRepository extends MongoRepository<Person, String> {

	public Person findByFirstName(String firstName);

	public List<Person> findByAge(int age);
}
