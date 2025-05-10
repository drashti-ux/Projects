package com.payload;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentDto {
	private int id;
	private String title;
	private UserDto user;
	private PostDto post;
}
