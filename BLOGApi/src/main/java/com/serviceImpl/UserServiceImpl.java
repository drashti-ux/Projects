package com.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.ResourceNotFoundException;
import com.model.User;
import com.payload.UserDto;
import com.repo.UserRepo;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public List<UserDto> allUser() {
		// TODO Auto-generated method stub
		List<User> users = userRepo.findAll();
		List<UserDto> dtos = new ArrayList<>();
		for(User u : users) {
			dtos.add(this.userToDto(u));
		}
		return dtos;
	}

	@Override
	public UserDto addUser(UserDto user) {
		// TODO Auto-generated method stub
		User createdUser =  userRepo.save(this.dtoToUser(user));
		return this.userToDto(createdUser);
	}

	@Override
	public UserDto updateUser(UserDto user, int id) {
		// TODO Auto-generated method stub
		user.setId(id);
		User u = userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("user", "id", id));
		u.setName(user.getName());
		u.setPassword(user.getPassword());
		u.setAbout(user.getAbout());
		User updatedUser = userRepo.save(u);
		
		return this.userToDto(updatedUser);
	}

	@Override
	public UserDto userById(int id) {
		// TODO Auto-generated method stub
		User u = userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("user","id",id));
		return this.userToDto(u);
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("user", "id", id));
		userRepo.deleteById(id);
	}

	public User dtoToUser(UserDto dto) {
		User user = mapper.map(dto, User.class);
//		user.setId(dto.getId());
//		user.setName(dto.getName());
//		user.setPassword(dto.getPassword());
//		user.setAbout(dto.getAbout());
		return user;
	}
	
	public UserDto userToDto(User user) {
		UserDto dto = mapper.map(user, UserDto.class);
		
//		dto.setId(user.getId());
//		dto.setName(user.getName());
//		dto.setPassword(user.getPassword());
//		dto.setAbout(user.getAbout());
		return dto;
	}
}
