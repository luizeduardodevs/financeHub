package com.financehub.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financehub.domain.User;

public interface UserRepositories extends JpaRepository<User, String> {
	
	Optional <User> findByCpf(Integer cpf);
}
