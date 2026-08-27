package com.financehub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financehub.domain.User;

public interface UserRepositories extends JpaRepository<User, String> {

}
