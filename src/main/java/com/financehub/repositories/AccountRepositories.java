package com.financehub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financehub.domain.Account;

public interface AccountRepositories extends JpaRepository <Account, String> {

}
