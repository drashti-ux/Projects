package com.payload;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {
	
	private int id;
	@NotBlank(message="Title Is required!!")
	private String title;
	@NotBlank(message="Content id Required!!")
	private String content;
	private String image;
	private UserDto user;
	private CategoryDto category;
}
