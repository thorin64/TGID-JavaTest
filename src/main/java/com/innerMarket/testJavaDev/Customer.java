package com.innerMarket.testJavaDev;

public class Customer {
	
	private static int idCustomerCounter = 1;
	
	private String name;
	private String cpf;
	private String email;

// Constructor
	public Customer(String name, String cpf, String email) {

		this.name = name;
		this.cpf = cpf;
		this.email = email;
		idCustomerCounter += 1 ;
	}

// Setters and Getters
	public String getName() {
	return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
	return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
	return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

// Print info
	public String toString() {
		return "\nNome: "+ this.getName() +
			"\nCPF: " + this.getCpf() +
			"\nE-Mail: " + this.getEmail();
	}
}
