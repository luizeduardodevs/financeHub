package com.financehub.controller;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.financehub.domain.Account;
import com.financehub.services.AccountServices;

@RestController
@RequestMapping(value="/accounts")
public class AccountController {

	@Autowired
	private AccountServices service;
	
	@GetMapping
	public ResponseEntity<List<Account>> findAll(){
		List<Account> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Account> findById(@PathVariable("id") String id){
		Account obj = service.findByid(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Account> insert(@RequestBody Account account){
		account = service.insert(account);
		URI uri = ServletUriComponentsBuilder // construção de componentes uri
				.fromCurrentRequest() // pega o endereço da solicitação atual, que fois passada no postman
				.path("/{id}") //adiciona o id ao fim da requisição 
				.buildAndExpand(account.getId())//pega o valor de dentro do id, e colocar no caminho passado acma
				.toUri();// http://localhost:8080/accounts/f2c48afa-2b25-4e5b-9e07-26ad375c1e52 é a uri se torna isso
		return ResponseEntity.created(uri).body(account);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") String id){	
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Account account, @PathVariable("id") String id ){
		account = service.update(id,account);
		return ResponseEntity.noContent().build();
	}
}
