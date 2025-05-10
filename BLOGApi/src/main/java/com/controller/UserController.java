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

import com.payload.UserDto;
import com.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> allUsers() {
		List<UserDto> users = userService.allUser();
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserDto user) {
		UserDto createdUser = userService.addUser(user);
		return new ResponseEntity<>(createdUser, HttpStatus.OK);
	}
	
	@PutMapping("/{uid}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto user,@PathVariable("uid") int id) {
		UserDto updatedUser = userService.updateUser(user, id);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}
	
	@DeleteMapping("/{uid}")
	public ResponseEntity<String> deleteUser(@PathVariable("uid") int id) {
		userService.deleteUser(id);
		return ResponseEntity.ok("User Deleted");
	}
	
	@GetMapping("{uid}")
	public ResponseEntity<UserDto> userById(@PathVariable("uid") int id) {
		UserDto userDto = userService.userById(id);
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}
}
