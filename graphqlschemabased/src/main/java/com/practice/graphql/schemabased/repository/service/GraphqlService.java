package com.practice.graphql.schemabased.repository.service;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.practice.graphql.schemabased.repository.service.dataFetcher.AllPersonsDataFetcher;
import com.practice.graphql.schemabased.repository.service.dataFetcher.PersonDataFetcher;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Service
public class GraphqlService implements GraphQLQueryResolver {

	// address of the schema file
	@Value("classpath:person.graphql")
	Resource resource;

	private GraphQL graphql;

	@Autowired
	private AllPersonsDataFetcher allPersonDataFetcher;

	@Autowired
	private PersonDataFetcher personDataFetcher;

	@PostConstruct
	private void loadSchema() throws IOException {
		// get the Schema file
		File schemaFile = resource.getFile();

		// parse schema and load into typeDefinitionRegistry
		TypeDefinitionRegistry registry = new SchemaParser().parse(schemaFile);
		// wire the schema
		RuntimeWiring wiring = buildRuntimeWiring();
		// get GraphQLSchema Object
		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(registry, wiring);
		// using GraphQLSchema Object get GraphQL Object
		graphql = GraphQL.newGraphQL(schema).build();
	}

	private RuntimeWiring buildRuntimeWiring() {
		return RuntimeWiring
				.newRuntimeWiring().type("Query", typeWiring -> typeWiring
						.dataFetcher("allPerson", allPersonDataFetcher).dataFetcher("person", personDataFetcher))
				.build();
	}

	public GraphQL getGrpahQl() {
		return graphql;
	}
}
