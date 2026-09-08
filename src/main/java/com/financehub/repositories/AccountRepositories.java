package com.financehub.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financehub.domain.Account;
import com.financehub.domain.User;

public interface AccountRepositories extends JpaRepository <Account, String> {
	
	Optional<Account> findByUser(User user);
}
