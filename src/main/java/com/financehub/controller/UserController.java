package com.financehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financehub.domain.User;
import com.financehub.services.UserServices;

@RestController // vai receber requisiçoes https
@RequestMapping(value = "/user") // definir o caminho do endpoints
public class UserController {
	
	@Autowired
	private UserServices service;

	@GetMapping	
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findall();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable("id") String id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<User> delete(@PathVariable("id") String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping(value="/{id}")
	public ResponseEntity<User> update(@RequestBody User user,@PathVariable String id){
		service.update(id, user);
		return ResponseEntity.noContent().build();
	}
	@PostMapping
	public ResponseEntity<User> cadastrar(@RequestBody User user){
		User salvo = service.cadastrar(user);
		return ResponseEntity.ok().body(salvo);
	}
	
}
