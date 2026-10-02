package com.financehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financehub.domain.Account;
import com.financehub.domain.PixKey;
import com.financehub.repositories.PixKeyRepositories;

@Service
public class PixKeyServices {
	
	@Autowired
	private PixKeyRepositories pixRepositories;
	
	public PixKey createdKeyPix(Account account, String key) {
		PixKey pixKey = new PixKey();
		pixKey.setKey(key);
		pixKey.setAccount(account);
		boolean obj = pixRepositories.existsByKey(key);
		if(obj) {
			throw new RuntimeException();
		}
		PixKey pixs = pixRepositories.save(pixKey);
		return pixs;
	}
}
