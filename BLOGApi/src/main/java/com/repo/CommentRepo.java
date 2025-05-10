package com.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Comment;
import com.model.User;
import com.model.Post;


public interface CommentRepo extends JpaRepository<Comment, Integer> {
	
	public List<Comment> findByUser(User user);
	public List<Comment> findByPost(Post post);
}
