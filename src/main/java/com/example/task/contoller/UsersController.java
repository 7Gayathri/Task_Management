package com.example.task.contoller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.task.model.Tasks;
import com.example.task.model.UserDto;
import com.example.task.model.Users;
import com.example.task.service.TasksService;
import com.example.task.service.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {

	@Autowired
	private UsersService userService;

	@Autowired
	private TasksService tasksService;
	
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
	public String login(@ModelAttribute("user") UserDto userDto, RedirectAttributes redirectAttributes, HttpSession session) {
	    Users user = userService.checkUser(userDto);
	    if (user == null) {
	        return "login"; // Redirect to login page if user is null
	    } else {
	        session.setAttribute("loggedInUser", user); // Store the user in session
	        List<Tasks> tasks = tasksService.getAllTasks(); // Fetch tasks
	        redirectAttributes.addFlashAttribute("listTasks", tasks); // Add tasks to redirect attributes
	        return "redirect:/index"; // Redirect to index page
	    }
	}


}
