package com.financehub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.financehub.domain.User;
import com.financehub.exceptions.ResourceNotFoundException;
import com.financehub.repositories.UserRepositories;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserServices {
	
	@Autowired
	private UserRepositories userRepositories;
	
	public List<User> findall(){
		return userRepositories.findAll();
	}
	public User findById(String id){
		Optional<User> obj = userRepositories.findById(id);
		return obj.orElseThrow(() -> new RuntimeException(id));
	}
	
	public void delete(String id) {
		try {
			userRepositories.deleteById(id);
		}catch(EmptyResultDataAccessException e){
			throw new ResourceNotFoundException(id);
		}
	}
	public User update(String id, User user) {
		try {
			User entity = userRepositories.getReferenceById(id);
			updateData(entity, user);
			return userRepositories.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public void updateData(User entity,User user) {
		entity.setEmail(user.getEmail());
		entity.setPassword(user.getPassword());
	}
	
	public User cadastrar(User user) {
		User salvo = userRepositories.save(user);//quero que o repositorio me retorno esse objeto que foi salvo dentro da variavel salva
		return salvo;
	}
}
