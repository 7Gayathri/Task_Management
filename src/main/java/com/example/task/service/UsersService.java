package com.example.task.service;

import java.util.List;

import com.example.task.model.UserDto;
import com.example.task.model.Users;

public interface UsersService {

	public Users saveUsers(Users user);
	
	public Users getUserById(long id);

	public List<Users> getAllUsers();

	public Users checkUser(UserDto userDto);
}
