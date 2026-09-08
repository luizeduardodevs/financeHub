package com.financehub.console;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.financehub.domain.User;
import com.financehub.services.UserServices;
@Component//fala que essa calsse faz parte da aplicação cria e gerencia um objeto dela 
public class FinanceHubConsole implements CommandLineRunner {
	@Autowired
	private UserServices userService;
	
	public void run(String... args) throws Exception {
	Scanner sc = new Scanner(System.in);
	
	String cpf = null;
	System.out.print("Welcome to FinanceHub ");
	System.out.println("Do you want to create an user?[yes/no]");
	String yesOrNo = sc.nextLine();
	if(yesOrNo.equals("yes")) {
		System.out.println("Enter your CPF: ");
		cpf = sc.nextLine();
		while (cpf.length() != 11) {
			System.out.println("Enter your correctly CPF: ");
			cpf = sc.nextLine();
		}
		String part1 = cpf.substring(0,3);
		String part2 =cpf.substring(3,6);
		String part3 = cpf.substring(6,9);
		String part4 =cpf.substring(9,11);
		cpf = (part1 + "." + part2 + "." + part3 + "-" + part4);
		System.out.println("Enter your name: ");
		String name = sc.nextLine();
		System.out.println("Enter your e-mail address: ");
		String email = sc.nextLine();
		System.out.println("Enter your password: ");
		String password = sc.nextLine();
		User user = new User(name,cpf,email,password);
		try{
			userService.cadastrar(user);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	}
}