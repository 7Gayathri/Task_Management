package com.example.task.service;

import java.util.List;

import com.example.task.model.Tasks;


public interface TasksService {

	public Tasks saveTask(Tasks task);

	public List<Tasks> getAllTasks();

	public  Tasks getTaskById(long id) ;

	public void deleteTasksById(long id);
		

}
