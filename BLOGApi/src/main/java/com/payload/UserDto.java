package com.payload;

import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Setter
@Getter
public class UserDto {
	
	private int id;
	@NotBlank(message = "Username Must be Required!!")
	private String name;
	
	@NotBlank(message = "password Must be Required!!")
	private String password;
	
	@NotBlank(message = "about must required!!")
	private String about;
	
	private Roledto role;
}
