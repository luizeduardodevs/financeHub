package com.financehub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.financehub.domain.Account;
import com.financehub.domain.User;
import com.financehub.exceptions.ResourceNotFoundException;
import com.financehub.repositories.AccountRepositories;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AccountServices {

	@Autowired
	private AccountRepositories accountRepo;
	
	public List<Account> findAll(){
		return accountRepo.findAll();
	}
	public Account findByid(String id) {
		Optional<Account> obj = accountRepo.findById(id);//averigua se tem ou nao tem.
		return obj.orElseThrow(() -> new RuntimeException(id));//retorne obj, ou entao lançe uma exceção
	}
	public Account insert(Account account) {
		return accountRepo.save(account);
	}
	public Account update(String id, Account account) {
		try {
			Account entity = accountRepo.getReferenceById(id);
			updateData(entity,account);
			return accountRepo.save(entity);
		}catch(EntityNotFoundException e) { 
			throw new ResourceNotFoundException(id);
		}
	}
	public void updateData(Account entity, Account account) {
		entity.setStatus(account.getStatus());
		entity.setType(account.getType());
		entity.setCreatedAt(account.getCreatedAt());
		entity.setNumberAccount(account.getNumberAccount());
	}
	public void delete(String id) {
		try {
			accountRepo.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	public Account abrirConta(User obj) {
		Account newAccount = new Account();
		newAccount.setUser(obj);
		Account account = accountRepo.save(newAccount);
		return account;
}
