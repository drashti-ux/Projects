package com.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Category;
import com.model.Post;
import com.model.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
	
	public List<Post> findByUser(User user);
	public List<Post> findByCategory(Category category);
	public List<Post> findByTitleContaining(String keyword);
	
}

