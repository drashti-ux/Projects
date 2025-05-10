package com.service;

import java.util.List;

import com.payload.UserDto;

public interface UserService {
	
	public List<UserDto> allUser();
	public UserDto addUser(UserDto user);
	public UserDto updateUser(UserDto user,int id);
	public UserDto userById(int id);
	public void deleteUser(int id);
}
