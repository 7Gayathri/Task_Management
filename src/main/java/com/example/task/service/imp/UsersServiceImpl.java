package com.example.task.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.task.model.UserDto;
import com.example.task.model.Users;
import com.example.task.repository.UsersRepositoryService;
import com.example.task.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepositoryService usersRepositoryService;

	@Override
	public Users saveUsers(Users user) {
		// TODO Auto-generated method stub
		return usersRepositoryService.save(user);
	}

	@Override
	public Users getUserById(long id) {
		// TODO Auto-generated method stub
		return usersRepositoryService.findById(id).get();
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return usersRepositoryService.findAll();
	}

	@Override
	public Users checkUser(UserDto userDto) {
		// TODO Auto-generated method stub
		return usersRepositoryService.findByemailAndPassword(userDto.getEmail(), userDto.getPassword());
	}

}
