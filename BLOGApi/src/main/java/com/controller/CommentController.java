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

import com.payload.ApiResponse;
import com.payload.CommentDto;
import com.repo.CategoryRepo;
import com.service.CommentService;

@RestController 
@RequestMapping("/comments")
public class CommentController {

    private final CategoryRepo categoryRepo;
	
	@Autowired
	CommentService commentService;

    CommentController(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }
	
	@PostMapping("/user/{uid}/post/{pid}")
	public ResponseEntity<CommentDto> addComment(@RequestBody CommentDto comment,@PathVariable("uid")int uid,@PathVariable("pid")int pid) {
		CommentDto createdComment = commentService.addComment(comment, uid, pid);
		return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CommentDto>> allComment() {
		List<CommentDto> comments = commentService.allComments();
		return new ResponseEntity<>(comments, HttpStatus.OK);
	}
	
	@DeleteMapping("/{cid}")
	public ResponseEntity<ApiResponse> deleteComment(@PathVariable("cid")int cid) {
		commentService.deleteComment(cid);
		return new ResponseEntity<>(new ApiResponse("Comment Deleted","true"), HttpStatus.OK);
	}
	
	@GetMapping("/{cid}")
	public ResponseEntity<CommentDto> commentById(@PathVariable("cid") int cid) {
		CommentDto comment = commentService.commentById(cid);
		return new ResponseEntity<>(comment,HttpStatus.OK);
	}
	
	@PutMapping("/{cid}/user/{uid}/post/{pid}")
	public ResponseEntity<CommentDto> updateComment(@RequestBody CommentDto comment,@PathVariable("cid")int cid,@PathVariable("uid")int uid,@PathVariable("pid")int pid) {
		CommentDto updatedComment = commentService.updateComment(comment, cid, uid, pid);
		return new ResponseEntity<>(updatedComment,HttpStatus.OK);
	}
	
	@GetMapping("/user/{uid}")
	public ResponseEntity<List<CommentDto>> commentByUser(@PathVariable("uid")int uid) {
		List<CommentDto> comments = commentService.commentByUser(uid);
		return new ResponseEntity<>(comments,HttpStatus.OK);
	}
	
	@GetMapping("/post/{pid}")
	public ResponseEntity<List<CommentDto>> commentByPost(@PathVariable("pid")int pid) {
		List<CommentDto> comments = commentService.commentByPost(pid);
		return new ResponseEntity<>(comments,HttpStatus.OK);
	}
}
