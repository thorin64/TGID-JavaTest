package com.innerMarket.testJavaDev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class TestJavaDevApplication {

	static Scanner input = new Scanner(System.in);
	static ArrayList<BankAccount> bankAccounts; 

	public static void main(String[] args) {
		SpringApplication.run(TestJavaDevApplication.class, args);
		bankAccounts = new ArrayList<BankAccount>();
		operations();
	}

	public static void operations() {
		System.out.println("--------------------------------------------------");
		System.out.println("-------------Bem vindo ao banco TGID--------------");
		System.out.println("--------------------------------------------------");
		System.out.println("*****Selecione a operação que deseja realizar*****");
		System.out.println("--------------------------------------------------");
		System.out.println("|	Opção 1 - Criar Conta	|");
		System.out.println("|	Opção 2 - Depositar	|");
		System.out.println("|	Opção 3 - Sacar		|");
		System.out.println("|	Opção 4 - Transferir	|");
		System.out.println("|	Opção 5 - Listar	|");
		System.out.println("|	Opção 6 - Sair		|");

		int operation = input.nextInt();
		switch (operation) {
			case 1:
				createAccount();
				break;
			case 2:
				deposit();
				break;
			case 3:
				withdraw();
				break;
			case 4:
				transfer();
				break;
			case 5:
				listAccounts();
				break;
			case 6:
				System.out.println("Volte Sempre!");
				System.exit(0);
			default:
				System.out.println("Opção Inválida!");
				operations();
				break;
		}
	}
	public static void createAccount() {

		System.out.println("\nNome: ");
		String name = input.next();

		System.out.println("\nCPF: ");
		String cpf = input.next();

		System.out.println("\nE-Mail: ");
		String email = input.next();

		Customer customer = new Customer(name, cpf, email);

		BankAccount account = new BankAccount(customer);

		bankAccounts.add(account);
		System.out.println("Conta criada com sucesso!");

		operations();
	}

	private static BankAccount findAccount(int accountNumber) {
		BankAccount account = null;
		if (bankAccounts.size() > 0) {
			for (BankAccount a: bankAccounts) {
				if (a.getAccountNumber() == accountNumber) {
				account = a;
			}
		}
		}
		return account;
	}

	public static void deposit() {
		System.out.println("Número da conta: ");
		int accountNumber = input.nextInt();

		BankAccount account = findAccount(accountNumber);

		if (account != null) {
			System.out.println("Qual valor deseja depositar?");
			Double depositValue = input.nextDouble();
			account.deposit(depositValue);
		} else {
			System.out.println("A conta não encontrada");
		}
		operations();
	}

	public static void withdraw() {
		System.out.println("Número da conta: ");
		int accountNumber = input.nextInt();

		BankAccount account = findAccount(accountNumber);

		if (account != null) {
			System.out.println("Qual valor deseja sacar?");
			Double withdrawValue = input.nextDouble();
			account.withdraw(withdrawValue);
		} else {
			System.out.println("A conta não encontrada");
		}
		operations();
	}

	public static void transfer() {
		System.out.println("Número da conta do remetente: ");
		int accountNumberSender = input.nextInt();
		BankAccount accountSender = findAccount(accountNumberSender);

		if (accountSender != null) {
		System.out.println("Número da conta do destinatário: ");
		int accountNumberReceiver = input.nextInt();

		BankAccount accountReceiver = findAccount(accountNumberReceiver);

			if (accountReceiver != null) {
				System.out.println("Valor da transferência: ");
				Double value = input.nextDouble();

				accountReceiver.transfer(accountReceiver, value);
			}
		}
		operations();
	}

	public static void listAccounts() {
		if (bankAccounts.size() > 0) {
			for (BankAccount account: bankAccounts) {
				System.out.println(account);
			}
		} else {
			System.out.println("Não há contas cadastradas.");
		}
	operations();
	}
}
