package com.graphql.latest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.graphql.latest.model.Person;

@Repository
public interface IPersonRepository extends MongoRepository<Person, String> {

}
