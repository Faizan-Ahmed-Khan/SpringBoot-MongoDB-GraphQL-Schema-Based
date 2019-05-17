package com.graphql.latest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.SchemaParser;
import com.graphql.latest.repository.resolver.MutationResolver;
import com.graphql.latest.repository.resolver.QueryResolver;

import graphql.execution.AsyncExecutionStrategy;
import graphql.execution.ExecutionStrategy;
import graphql.schema.GraphQLSchema;
import graphql.servlet.GraphQLServlet;
import graphql.servlet.SimpleGraphQLServlet;

@Component
public class GraphQLConfig {
	@Autowired
	QueryResolver queryResolver;

	@Autowired
	MutationResolver mutationResolver;

	@Bean
	public ServletRegistrationBean<GraphQLServlet> servletRegistrationBean() {
		GraphQLSchema schema = SchemaParser.newParser().resolvers(queryResolver, mutationResolver)
				.file("person.graphqls").build().makeExecutableSchema();
		ExecutionStrategy executionStrategy = new AsyncExecutionStrategy();
		GraphQLServlet servlet = new SimpleGraphQLServlet(schema, executionStrategy);
		return new ServletRegistrationBean<>(servlet, "/graphql");
	}
}
