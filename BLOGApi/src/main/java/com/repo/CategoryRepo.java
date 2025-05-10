package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
