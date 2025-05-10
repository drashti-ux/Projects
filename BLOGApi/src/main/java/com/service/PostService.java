package com.service;

import java.util.List;

import com.payload.PostDto;

public interface PostService {
	
	public List<PostDto> allPosts(int pageNumber,int pageSize,String sortBy,String sortType);
	public PostDto addPost(PostDto post,int cid,int uid);
	public PostDto updatePost(PostDto post,int id,int cid,int uid);
	public PostDto postById(int id);
	public void deletePost(int id);
	public List<PostDto> postByUser(int uids);
	public List<PostDto> postByCategory(int cid);
	public List<PostDto> searchPost(String keyword);
	public PostDto addImage(PostDto post);
}
