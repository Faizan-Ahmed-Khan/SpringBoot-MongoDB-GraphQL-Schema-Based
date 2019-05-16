package com.practice.graphql.schemabased.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Person {
	@Id
	String id;
	String firstName;
	String lname;
	int age;

	public Person(String firstName, String lname, int age) {
		this.firstName = firstName;
		this.lname = lname;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFname() {
		return firstName;
	}

	public void setFname(String fname) {
		this.firstName = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person -> firstName :: " + firstName + " lname:: " + lname + " age:: " + age;
	}

}
