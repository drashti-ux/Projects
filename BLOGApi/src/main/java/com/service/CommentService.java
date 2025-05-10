package com.service;

import java.util.List;

import com.payload.CommentDto;

public interface CommentService {
	
	public List<CommentDto> allComments();
	public CommentDto addComment(CommentDto com,int uid,int pid);
	public CommentDto updateComment(CommentDto com,int id,int uid,int pid);
	public CommentDto commentById(int id);
	public void deleteComment(int id);
	public List<CommentDto> commentByUser(int uid);
	public List<CommentDto> commentByPost(int pid); 
}
