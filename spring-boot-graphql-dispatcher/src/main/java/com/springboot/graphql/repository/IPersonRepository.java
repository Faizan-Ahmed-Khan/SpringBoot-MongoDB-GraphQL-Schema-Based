package com.springboot.graphql.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.graphql.model.Person;

public interface IPersonRepository extends MongoRepository<Person, String> {

	Person findByFirstName(String firstName);
}
