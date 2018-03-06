package com.sqli.nespresso.gossips;

public class Person {

	public Person(String name) {
		this.name = name;
	}
	
	private final String name;
	private String salutations;
	
	private Person next;
	
	public String getName() {
		return name;
	}
	
	public String getSalutations() {
		return salutations;
	}
	
	public void setSalutations(String salutations) {
		this.salutations = salutations;
	}

	public Person getNext() {
		return next;
	}

	public void setNext(Person next) {
		this.next = next;
	}
	
}
