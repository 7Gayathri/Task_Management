package com.example.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.task.model.Tasks;


@Repository
public interface TasksRepositoryService extends JpaRepository<Tasks, Long> {

}
