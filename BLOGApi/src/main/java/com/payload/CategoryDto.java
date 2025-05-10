package com.payload;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryDto {
	private int id;
	@NotBlank(message = "title must required!!")
	private String title;
}
