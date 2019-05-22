package com.springboot.graphql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.graphql.service.GraphQLService;

import graphql.ExecutionResult;

@RestController
public class PersonController {

	@Autowired
	GraphQLService graphQLService;

	@PostMapping("/person")
	public ResponseEntity<Object> resolveQuery(@RequestBody String query) {
		ExecutionResult result = graphQLService.getGraphQL().execute(query);

		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
