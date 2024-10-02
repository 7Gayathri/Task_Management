package com.example.task.contoller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.task.model.UserDto;
import com.example.task.model.Users;
import com.example.task.service.UsersService;

@Controller
public class UsersController {

	@Autowired
	private UsersService userService;

	@GetMapping("/signup")
	public String viewloginpage(Model model) {
		Users user = new Users();
		model.addAttribute("user", user);
		return "signup";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") Users user) {
		userService.saveUsers(user);
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("user")UserDto userDto) {
		Users user= userService.checkUser(userDto);
		if(user==null) {
			return "login";
		}else {
			return "index";
		}
	}

}
