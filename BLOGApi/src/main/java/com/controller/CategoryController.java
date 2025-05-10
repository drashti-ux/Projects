package com.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payload.CategoryDto;
import com.service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> allCategory() {
		List<CategoryDto> categories = categoryService.allCategory();
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> addCategory(@Valid @RequestBody CategoryDto dto) {
		CategoryDto createdCategory = categoryService.addCategory(dto);
		return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
	}
	
	@DeleteMapping("{cid}")
	public ResponseEntity<String> deleteCategory(@PathVariable("cid")int cid) {
		categoryService.deleteCategory(cid);
		return ResponseEntity.ok("Category Deleted");
	}
	
	@PutMapping("{cid}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto cat,@PathVariable("cid") int id) {
		CategoryDto updatedCategory = categoryService.updateCategory(cat, id);
		return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
	}
	
	@GetMapping("/{cid}")
	public ResponseEntity<CategoryDto> categoryById(@PathVariable("cid")int id) {
		CategoryDto cat = categoryService.categoryById(id);
		return new ResponseEntity<>(cat, HttpStatus.OK);
	}
}
