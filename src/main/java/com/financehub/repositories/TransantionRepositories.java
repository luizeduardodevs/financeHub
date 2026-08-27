package com.financehub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financehub.domain.Transantion;

public interface TransantionRepositories extends JpaRepository <Transantion, String> {
//metodos de acesso ao banco, repository sao metodos de acesso
}
