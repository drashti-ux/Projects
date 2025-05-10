package com.service;

import java.util.List;

import com.payload.CategoryDto;

public interface CategoryService {
	
	public List<CategoryDto> allCategory();
	public CategoryDto addCategory(CategoryDto cat);
	public CategoryDto updateCategory(CategoryDto cat,int id);
	public CategoryDto categoryById(int id);
	public void deleteCategory(int id);
}
