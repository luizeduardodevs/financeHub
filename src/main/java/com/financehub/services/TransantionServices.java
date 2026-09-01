package com.financehub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financehub.domain.Transantion;
import com.financehub.repositories.TransantionRepositories;

@Service
public class TransantionServices {
	
	@Autowired
	private TransantionRepositories transantionRepo;
	
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

}
