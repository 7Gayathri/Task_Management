package com.example.task.contoller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.task.model.Tasks;
import com.example.task.model.UserDto;
import com.example.task.service.TasksService;


@Controller
public class TaskController {
	
	@Autowired
	private TasksService tasksService;
	@GetMapping("/")
	public String viewloginpage(Model model) {
		UserDto userDto=new UserDto();
		model.addAttribute("user",userDto);
		return "login";
	}

	 @GetMapping("/index")
	    public String viewHomePage(Model model) {
	        model.addAttribute("listTasks", tasksService.getAllTasks());
	        return "index";
	    }

	    @GetMapping("/showNewTasksForm")
	    public String showNewUsersForm(Model model) {
	        // create model attribute to bind form data
	        Tasks Tasks = new Tasks();
	        model.addAttribute("Task", Tasks);
	        return "new_tasks";
	    }

	    @PostMapping("/saveTasks")
	    public String saveTasks(@ModelAttribute("Task") Tasks Tasks) {
	        // save Users to database
	        tasksService.saveTask(Tasks);
	        return "redirect:/index";
	    }

	    @GetMapping("/showFormForUpdate/{id}")
	    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

	        // get Users from the service
	        Tasks Tasks = tasksService.getTaskById(id);

	        // set Users as a model attribute to pre-populate the form
	        model.addAttribute("Task", Tasks);
	        return "update_tasks";
	    }

	    @GetMapping("/deleteTasks/{id}")
	    public String deleteTasks(@PathVariable(value = "id") long id) {

	        // call delete Users method 
	        tasksService.deleteTasksById(id);
	        return "redirect:/index";
	    }

}
