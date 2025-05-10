package com.controller;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.payload.ApiResponse;
import com.payload.PostDto;
import com.service.ImageService;
import com.service.PostService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/posts")
public class PostController {

	
	@Autowired
	PostService postService;
	
	@Autowired
	ImageService imageService;
	
	@Value("${project.image}")
	String path;


	@GetMapping("/")
	public ResponseEntity<List<PostDto>> allPost(@RequestParam(value="pageNumber", defaultValue="1")int pageNumber,@RequestParam(value="pageSize",defaultValue="1")int pageSize,@RequestParam(value="sortBy",defaultValue="id")String sortBy,@RequestParam("sortType")String sortType) {
		List<PostDto> posts = postService.allPosts(pageNumber,pageSize,sortBy,sortType);
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}
	
	@PostMapping("/user/{uid}/category/{cid}")
	public ResponseEntity<PostDto> addPost(@Valid @RequestBody PostDto post,@PathVariable("uid") int uid,@PathVariable("cid")int cid) {
		PostDto createdPost = postService.addPost(post, cid, uid);
		return new ResponseEntity<>(createdPost,HttpStatus.CREATED);
	}
	
	@PutMapping("/{pid}/user/{uid}/category/{cid}")
	public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto post,@PathVariable("pid")int pid,@PathVariable("uid")int uid,@PathVariable("cid")int cid) {
		PostDto updatedPost = postService.updatePost(post, pid, cid, uid);
		return new ResponseEntity<>(updatedPost, HttpStatus.OK);
	}
	
	@DeleteMapping("/{pid}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable("pid")int pid) {
		postService.deletePost(pid);
		return new ResponseEntity<>(new ApiResponse("Post Deleted","true"), HttpStatus.OK);
	}
	
	@GetMapping("/{pid}")
	public ResponseEntity<PostDto> postById(@PathVariable("pid")int pid) {
		PostDto post =  postService.postById(pid);
		return new ResponseEntity<>(post, HttpStatus.OK);
	}
	
	@GetMapping("/user/{uid}")
	public ResponseEntity<List<PostDto>> postsByUser(@PathVariable("uid")int uid) {
		List<PostDto> posts = postService.postByUser(uid);
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}
	
	@GetMapping("/category/{cid}")
	public ResponseEntity<List<PostDto>> postsByCategory(@PathVariable("cid")int cid) {
		List<PostDto> posts = postService.postByCategory(cid);
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}
	
	@GetMapping("/search/{keyword}")
	public ResponseEntity<List<PostDto>> searchPost(@PathVariable("keyword")String keyword) {
		List<PostDto> posts = postService.searchPost(keyword);
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}
	
	@PostMapping("/upload/{pid}")
	public ResponseEntity<PostDto> upload(@PathVariable("pid") int pid,@RequestParam("image")MultipartFile file) {
		PostDto post = postService.postById(pid);
		String img = imageService.uploadImage(path, file);
		post.setImage(img);
		
		PostDto createdImage = postService.addImage(post);
		return new ResponseEntity<>(createdImage, HttpStatus.OK);
	}
	
	@GetMapping(produces = MediaType.IMAGE_JPEG_VALUE,value="/image/{imagename}")
	public ResponseEntity<Resource> viewImage(@PathVariable("imagename")String imagename) {
		InputStream is = imageService.getImage(path, imagename);
		Resource resource = new InputStreamResource(is);
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(resource);
	}
}
