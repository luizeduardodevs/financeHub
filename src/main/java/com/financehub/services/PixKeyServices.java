package com.financehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financehub.domain.Account;
import com.financehub.domain.PixKey;
import com.financehub.domain.User;
import com.financehub.repositories.PixKeyRepositories;

@Service
public class PixKeyServices {
	
	@Autowired
	private PixKeyRepositories pixRepositories;
	
	public PixKey createdKeyPix(User user ,Account account ) {
		
	}
}
