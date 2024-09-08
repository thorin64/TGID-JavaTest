package com.innerMarket.testJavaDev;

import com.innerMarket.utility.Utils;

/**
 * BankAccount
 */

public class BankAccount {

	private static int IdBankAccount;

	private int accountNumber;
	private Customer customer;
	private Double balance = 0.0;

	public BankAccount(Customer customer) {
		this.accountNumber = IdBankAccount;
		this.customer = customer;
		IdBankAccount += 1;
	}
// Setters and Getters
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
// print info
	@Override
	public String toString() {
		return "\nAccount Number: " + this.getAccountNumber() +
		 "\nNome: " + this.customer.getName() +
		 "\nCPF: " + this.customer.getCpf() +
		 "\nE-Mail: " + this.customer.getEmail() +
		 "\nSaldo: " + Utils.doubleToString(this.getBalance()) +
		 "\n";
	}
// methods
	public void deposit(Double value) {
		if (value > 0) {
			setBalance(getBalance() + value);
			System.out.println("Depósito realizado com sucesso!");
		} else {
			System.out.println("Não foi possível efetuar o depósito.");
		}
	}
	
	public void withdraw(Double value) {
		if (value > 0 && this.getBalance() >= value) {
			setBalance(getBalance() - value);
			System.out.println("Saque realizado com sucesso!");
		} else {
			System.out.println("Não foi possível efetuar o saque.");
		}
	}
	
	public void transfer(BankAccount receivingAccount, Double value) {
		if (value > 0 && this.getBalance() >= value) {
			setBalance(getBalance() - value);

			receivingAccount.balance = receivingAccount.getBalance() + value;
			System.out.println("Transferência efetuada com sucesso.");
		} else {
			System.out.println("Não foi possível realizar a transferência.");
		}
	}
}
