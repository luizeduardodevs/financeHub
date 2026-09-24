package com.financehub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financehub.domain.PixKey;

public interface PixKeyRepositories extends JpaRepository <PixKey, String> {

}
