package com.financehub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financehub.domain.Category;

public interface CategoryRepositories extends JpaRepository <Category,String> {

}
