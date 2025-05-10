package com.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.ResourceNotFoundException;
import com.model.Category;
import com.payload.CategoryDto;
import com.repo.CategoryRepo;
import com.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public List<CategoryDto> allCategory() {
		// TODO Auto-generated method stub
		List<Category> categories = categoryRepo.findAll();
		List<CategoryDto> dtos = categories.stream().map((cat)->mapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public CategoryDto addCategory(CategoryDto cat) {
		// TODO Auto-generated method stub
		Category createdCategory = categoryRepo.save(mapper.map(cat, Category.class));
		return mapper.map(createdCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto cat, int id) {
		// TODO Auto-generated method stub
		Category catt = categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("category", "id", id));
		cat.setId(id);
		Category updatedCategory = categoryRepo.save(mapper.map(cat, Category.class));
		return mapper.map(updatedCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto categoryById(int id) {
		// TODO Auto-generated method stub
		Category cat = categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("category", "id", id));
		return mapper.map(cat, CategoryDto.class);
	}

	@Override
	public void deleteCategory(int id) {
		// TODO Auto-generated method stub
		Category catt = categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("category", "id", id));
		categoryRepo.deleteById(id);
	}
	

}
