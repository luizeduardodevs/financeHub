package com.financehub;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.financehub.console.FinanceHubConsole;

@SpringBootApplication
public class FinanceHubApplication{

	public static void main(String[] args) {
		SpringApplication.run(FinanceHubApplication.class, args);
	}
}
