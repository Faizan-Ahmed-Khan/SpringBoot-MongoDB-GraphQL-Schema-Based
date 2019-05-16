package com.practice.graphql.schemabased.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.graphql.schemabased.repository.service.GraphqlService;

import graphql.ExecutionResult;

@RestController
public class PersonGraphqlController {

	@Autowired
	private GraphqlService service;

	@PostMapping("/graphql/person")
	public ResponseEntity<Object> resolveQuery(@RequestBody String query) {
		ExecutionResult result = service.getGrpahQl().execute(query);
		return new ResponseEntity<Object>(result, HttpStatus.OK);
	}
}
