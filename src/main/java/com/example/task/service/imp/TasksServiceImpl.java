package com.example.task.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.task.model.Tasks;
import com.example.task.repository.TasksRepositoryService;
import com.example.task.service.TasksService;


@Service
public class TasksServiceImpl implements TasksService {

	@Autowired
	private TasksRepositoryService tasksRepositoryService;

	@Override
	public Tasks saveTask(Tasks task) {
		return tasksRepositoryService.save(task);
	}

	@Override
	public List<Tasks> getAllTasks() {
		return tasksRepositoryService.findAll();
	}

	@Override
	public Tasks getTaskById(long id) {
		return tasksRepositoryService.findById(id).get();
	}

	@Override
	public void deleteTasksById(long id) {
		tasksRepositoryService.deleteById(id);
	}
	

}
