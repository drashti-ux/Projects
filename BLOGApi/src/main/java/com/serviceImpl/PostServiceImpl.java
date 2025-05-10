package com.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.exception.ResourceNotFoundException;
import com.model.Category;
import com.model.Post;
import com.model.User;
import com.payload.CategoryDto;
import com.payload.PostDto;
import com.payload.UserDto;
import com.repo.CategoryRepo;
import com.repo.PostRepo;
import com.repo.UserRepo;
import com.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostRepo postRepo;
	
	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	ModelMapper mapper;
	
	
	@Override
	public List<PostDto> allPosts(int pageNumber,int pageSize,String sortBy,String sortType) {
		// TODO Auto-generated method stubs
		Sort sort ;
		if(sortType.equalsIgnoreCase("asc")) {
			sort = Sort.by(sortBy).ascending();
		}
		else {
			sort = Sort.by(sortBy).descending();
		}
		Pageable page = PageRequest.of(pageNumber,pageSize,sort);
		Page postPage = postRepo.findAll(page); 
		List<Post> posts = postPage.getContent();
		List<PostDto> postDto = posts.stream().map((e)-> mapper.map(e, PostDto.class)).collect(Collectors.toList());
		return postDto;
	}

	@Override
	public PostDto addPost(PostDto post,int cid,int uid) {
		// TODO Auto-generated method stub
		Category cat = categoryRepo.findById(cid).orElseThrow(()->new ResourceNotFoundException("Category", "id", cid));
		post.setCategory(mapper.map(cat, CategoryDto.class));
		
		User u = userRepo.findById(uid).orElseThrow(()->new ResourceNotFoundException("User", "Id", uid));
		post.setUser(mapper.map(u, UserDto.class));
		
		post.setImage("test.jpg");
		
		Post createdPost = postRepo.save(mapper.map(post, Post.class));
		return mapper.map(createdPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto post, int id,int cid,int uid) {
		// TODO Auto-generated method stub
		Post p = postRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Post", "Id", id));
		p.setTitle(post.getTitle());
		p.setContent(post.getContent());
		p.setImage(post.getImage());
		Category cat = categoryRepo.findById(cid).orElseThrow(()->new ResourceNotFoundException("Category", "Id", cid));
		p.setCategory(cat);
		User user = userRepo.findById(uid).orElseThrow(()-> new ResourceNotFoundException("User", "Id", uid));
		p.setUser(user);
		Post updatedPost = postRepo.save(p);
		
		return mapper.map(updatedPost, PostDto.class);
	}

	@Override
	public PostDto postById(int id) {
		// TODO Auto-generated method stub
		Post post = postRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Post", "Id", id));
		return mapper.map(post, PostDto.class);
	}

	@Override
	public void deletePost(int id) {
		// TODO Auto-generated method stub
		Post post = postRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "Id", id));
		postRepo.delete(post);
	}

	@Override
	public List<PostDto> postByUser(int uid) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(uid).orElseThrow(()->new ResourceNotFoundException("User", "Id", uid));
		List<Post> postByUser = postRepo.findByUser(user);
		List<PostDto> dtos = postByUser.stream().map(dto->mapper.map(dto, PostDto.class)).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public List<PostDto> postByCategory(int cid) {
		// TODO Auto-generated method stub
		Category cat = categoryRepo.findById(cid).orElseThrow(()->new ResourceNotFoundException("Category", "Id", cid));
		List<Post> postByUser = postRepo.findByCategory(cat);
		List<PostDto> dtos = postByUser.stream().map(dto->mapper.map(dto, PostDto.class)).collect(Collectors.toList());
		return dtos;	
		
	}
	
	public List<PostDto> searchPost(String keyword){
		List<Post> post = postRepo.findByTitleContaining(keyword);
		List<PostDto> dtos = post.stream().map(e->mapper.map(e, PostDto.class)).collect(Collectors.toList());
		return dtos;
	}
	
	public PostDto addImage(PostDto post) {
		Post p = mapper.map(post, Post.class);
		Post createdPost = postRepo.save(p);
		return mapper.map(createdPost, PostDto.class);
				
	}
}
