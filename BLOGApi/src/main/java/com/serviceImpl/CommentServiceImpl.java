package com.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.ResourceNotFoundException;
import com.model.Comment;
import com.model.Post;
import com.model.User;
import com.payload.CommentDto;
import com.payload.PostDto;
import com.payload.UserDto;
import com.repo.CommentRepo;
import com.repo.PostRepo;
import com.repo.UserRepo;
import com.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	CommentRepo commentRepo;
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	PostRepo postRepo;
	
	@Override
	public List<CommentDto> allComments() {
		// TODO Auto-generated method stub
		List<Comment> allcomment = commentRepo.findAll();
		List<CommentDto> dtos = allcomment.stream().map((comm)->mapper.map(comm, CommentDto.class)).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public CommentDto addComment(CommentDto com,int uid,int pid) {
		
		// TODO Auto-generated method stub
		User user = userRepo.findById(uid).orElseThrow(()->new ResourceNotFoundException("User", "Id", uid));
		Post post = postRepo.findById(pid).orElseThrow(()->new ResourceNotFoundException("Post", "Id", pid));
		com.setUser(mapper.map(user, UserDto.class));
		com.setPost(mapper.map(post, PostDto.class));
		Comment createdComment = commentRepo.save(mapper.map(com, Comment.class));
		return mapper.map(createdComment, CommentDto.class);
	}

	@Override
	public CommentDto updateComment(CommentDto com, int id,int uid,int pid) {
		// TODO Auto-generated method stub
		Comment comment = commentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Comment", "Id", id));
		User user = userRepo.findById(uid).orElseThrow(()->new ResourceNotFoundException("User", "Id", uid));
		Post post = postRepo.findById(pid).orElseThrow(()->new ResourceNotFoundException("Post", "Id", pid));
		com.setUser(mapper.map(user, UserDto.class));
		com.setPost(mapper.map(post, PostDto.class));
		com.setId(comment.getId());
		com.setTitle(comment.getTitle());
		Comment createdComment = commentRepo.save(mapper.map(com, Comment.class));
		return mapper.map(createdComment, CommentDto.class);
	}

	@Override
	public CommentDto commentById(int id) {
		// TODO Auto-generated method stub
		Comment comment = commentRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Comment", "Id", id));
		return mapper.map(comment, CommentDto.class);
	}

	@Override
	public void deleteComment(int id) {
		// TODO Auto-generated method stub
		Comment comment = commentRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Comment", "Id", id));
		commentRepo.delete(comment);
	}

	@Override
	public List<CommentDto> commentByUser(int uid) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(uid).orElseThrow(()->new ResourceNotFoundException("User", "Id", uid));
		List<Comment> byUser = commentRepo.findByUser(user);
		List<CommentDto> collect = byUser.stream().map((dto)->mapper.map(dto, CommentDto.class)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public List<CommentDto> commentByPost(int pid) {
		// TODO Auto-generated method stub
		Post post = postRepo.findById(pid).orElseThrow(()->new ResourceNotFoundException("Post", "Id", pid));
		List<Comment> byPost = commentRepo.findByPost(post);
		List<CommentDto> collect = byPost.stream().map((dto)->mapper.map(dto, CommentDto.class)).collect(Collectors.toList());
		return collect;
	}

}
