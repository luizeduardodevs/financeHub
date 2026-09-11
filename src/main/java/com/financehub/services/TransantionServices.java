package com.financehub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financehub.domain.Account;
import com.financehub.domain.Transantion;
import com.financehub.domain.User;
import com.financehub.exceptions.ResourceNotFoundException;
import com.financehub.repositories.AccountRepositories;
import com.financehub.repositories.TransantionRepositories;
import com.financehub.repositories.UserRepositories;

@Service
public class TransantionServices {
	
	@Autowired
	private TransantionRepositories transantionRepo;
	@Autowired
	private UserRepositories userRepositories;
	@Autowired
	private AccountRepositories accountRepo;
	
	
	public List<Transantion> findAll(){
		return transantionRepo.findAll();
	}
	
	public Transantion findById(String id) {
		Optional<Transantion> obj = transantionRepo.findById(id);
		return obj.orElseThrow(() -> new RuntimeException(id));
	}
	public Transantion insert(Transantion transantion) {
		return transantionRepo.save(transantion);
	}
	public Double transfer(Double value,String cpf, Account account) {
		if(value <= account.getValue() && value > 0)  {
			Optional<User> user = userRepositories.findByCpf(cpf);
			User userOne = user.orElseThrow(() -> new ResourceNotFoundException(user));
			Optional<Account> accountOne = accountRepo.findByUser(userOne);
			Account destinary = accountOne.orElseThrow(()-> new ResourceNotFoundException(accountOne));
			destinary.setValue(destinary.getValue()+value);
			account.setValue(account.getValue()- value);
			accountRepo.save(destinary);
			accountRepo.save(account);
			return account.getValue();		
		}else {
			throw new RuntimeException("Value can´t transfering for puther account destinary"+account);
		}
		
		
	 }

}
