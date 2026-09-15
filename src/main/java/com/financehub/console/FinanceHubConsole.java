package com.financehub.console;

import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.financehub.domain.Account;
import com.financehub.domain.User;
import com.financehub.repositories.AccountRepositories;
import com.financehub.repositories.UserRepositories;
import com.financehub.services.AccountServices;
import com.financehub.services.TransantionServices;
import com.financehub.services.UserServices;
@Component//fala que essa calsse faz parte da aplicação cria e gerencia um objeto dela 
public class FinanceHubConsole implements CommandLineRunner {
	private final UserRepositories userRepositories;
	private final AccountRepositories accountRepositories;
	@Autowired
	private UserServices userService;
	@Autowired
	private AccountServices accountService;
	@Autowired
	private TransantionServices transantionServices;

	FinanceHubConsole(AccountRepositories accountRepositories, UserRepositories userRepositories) {
		this.accountRepositories = accountRepositories;
		this.userRepositories = userRepositories;
	}
	
	public void run(String... args) throws Exception {
		
	//ARRUMA LOGICA , POIS QUNADO INFORMAR O CPF QUE JA EXISTE TRAVA.
	Scanner sc = new Scanner(System.in);
	sc.useLocale(Locale.US);
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	Account account = null;
	User user = null;
	
	String cpf = null;
	System.out.println("Welcome to FinanceHub ");
	System.out.print("Do you want to create an user?[yes/no]: ");
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
		user = new User(name,cpf,email,password);
		try{
			User salvo = userService.cadastrar(user);
			System.out.println("Account created with the CPF of: " + salvo.getCpf());
			accountService.openAccount(salvo);//criou o usuario
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}	
		}else {//se nao
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
		user = userService.searchCpf(cpf);//tem que achar o usuario
		System.out.print("Enter your password: ");
		String passwords = sc.nextLine();
			while(!passwords.equals(user.getPassword())) {
				System.out.print("Enter your password:");
				passwords = sc.nextLine();
				}//acaba aqui
			Optional<Account> obj = accountRepositories.findByUser(user);
			account = obj.orElseThrow();
			if(account.getValue() == null) {
				System.out.println("which the value inital of account will yours be:");
				Double value = sc.nextDouble();
				account.setValue(value);
				accountRepositories.save(account);
				System.out.println("Total value " + account.getValue());
			}
			System.out.println("Total value: " + account.getValue());
	}
	Optional<Account> obj = accountRepositories.findByUser(user);
	account = obj.orElseThrow();
	//inserido o valor na conta valor 
	if(account.getValue() == null) {
		System.out.println("which the value inital of account will yours be:");
		Double value = sc.nextDouble();
		account.setValue(value);
		accountRepositories.save(account);
		System.out.println("Total value " + account.getValue());
		sc.nextLine();}
		
	System.out.println("Do you want to do a transfer?");
	String transfer = sc.nextLine();
	if(transfer.equals("yes")) {
		System.out.println("which the value what you will make the tansfer:");
		Double value = sc.nextDouble();
		System.out.println("For who´s will be done the transfer? report the cpf: ");
		sc.nextLine();
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
		User userDestinary = userService.searchCpf(cpf);
		System.out.println("Do you really want to make transfer for the people? " + userDestinary.getName()+ " with the "+ userDestinary.getCpf());
		yesOrNo = sc.nextLine();
		if(yesOrNo.equals("yes")){
			transantionServices.transfer(value, cpf, account);	
			accountRepositories.save(account);
			System.out.println("Operation successfully completed, your new value of Account is of " + account.getValue());
			}
		}
	
		
		
		
		
		
	}
	
}