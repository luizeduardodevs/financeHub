package com.financehub.console;

import com.financehub.repositories.AccountRepositories;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.financehub.domain.Account;
import com.financehub.domain.User;
import com.financehub.services.AccountServices;
import com.financehub.services.UserServices;
@Component//fala que essa calsse faz parte da aplicação cria e gerencia um objeto dela 
public class FinanceHubConsole implements CommandLineRunner {
	private final AccountRepositories accountRepositories;
	@Autowired
	private UserServices userService;
	@Autowired
	private AccountServices accountService;

	FinanceHubConsole(AccountRepositories accountRepositories) {
		this.accountRepositories = accountRepositories;
	}
	
	public void run(String... args) throws Exception {
	
	Scanner sc = new Scanner(System.in);
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	String cpf = null;
	System.out.print("Welcome to FinanceHub ");
	System.out.print("Do you want to create an user?[yes/no]");
	String yesOrNo = sc.nextLine();
	if(yesOrNo.equals("yes")) {
		System.out.print("Enter your CPF: ");
		cpf = sc.nextLine();
		while (cpf.length() != 11) {
			System.out.print("Enter your correctly CPF: ");
			cpf = sc.nextLine();
		}
		String part1 = cpf.substring(0,3);
		String part2 =cpf.substring(3,6);
		String part3 = cpf.substring(6,9);
		String part4 =cpf.substring(9,11);
		cpf = (part1 + "." + part2 + "." + part3 + "-" + part4);
		System.out.print("Enter your name: ");
		String name = sc.nextLine();
		System.out.print("Enter your e-mail address: ");
		String email = sc.nextLine();
		System.out.print("Enter your password: ");
		String password = sc.nextLine();
		User user = new User(name,cpf,email,password);
		try{
			User salvo = userService.cadastrar(user);
			System.out.println("cpf gerado" + salvo.getCpf());
			accountService.openAccount(user);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	System.out.print("Enter your cpf: ");
	cpf = sc.nextLine();
	while(cpf.length() != 11) {
		System.out.print("Enter your correctly CPF: ");
		cpf = sc.nextLine();
	}
	String part1 = cpf.substring(0,3);
	String part2 =cpf.substring(3,6);
	String part3 = cpf.substring(6,9);
	String part4 =cpf.substring(9,11);
	cpf = (part1 + "." + part2 + "." + part3 + "-" + part4);
	
	User user = userService.searchCpf(cpf);
	System.out.print("Enter your password: ");
	String passwords = sc.nextLine();
		while(!passwords.equals(user.getPassword())) {
			System.out.print("Enter your password: ");
			passwords = sc.nextLine();
	
	}if(cpf.equals(user.getCpf()) && passwords.equals(user.getPassword())) {
		Account account = user.getAccounts();
		System.out.println("which the value inital of account will yours be:");
		Double value = sc.nextDouble();
		account.setValue(value);
		accountRepositories.save(account);
	}

	
	
	
	
	}
}