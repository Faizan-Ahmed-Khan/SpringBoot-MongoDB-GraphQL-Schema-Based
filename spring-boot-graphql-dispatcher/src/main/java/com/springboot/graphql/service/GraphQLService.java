package com.springboot.graphql.service;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.springboot.graphql.service.datafetcher.PersonsDataFetcher;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Service
public class GraphQLService {

	@Autowired
	private PersonsDataFetcher dataFetcher;

	@Value("classpath:person.graphql")
	Resource resource;

	private GraphQL graphQL;
//	@Autowired
//	private AllPersonsDataFetcher allPersonDataFetcher;
//
//	@Autowired
//	private PersonDataFetcher personDataFetcher;

	// load schema at application start up
	@PostConstruct
	private void loadSchema() throws IOException {
		// get the schema
		File schemaFile = resource.getFile();
		// parse schema
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
		RuntimeWiring wiring = buildRuntimeWiring();
		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
		graphQL = GraphQL.newGraphQL(schema).build();
	}

	private RuntimeWiring buildRuntimeWiring() {
		return RuntimeWiring.newRuntimeWiring()
				.type("Query",
						typeWiring -> typeWiring
						.dataFetcher("allPerson", dataFetcher.getAllPerson())
						.dataFetcher("person", dataFetcher.getPersonByFirstName()))
				.type("Mutation", typeWiring -> typeWiring
						.dataFetcher("createPerson", dataFetcher.createNewPerson()))
				.build();
	}

	public GraphQL getGraphQL() {
		return graphQL;
	}
}
