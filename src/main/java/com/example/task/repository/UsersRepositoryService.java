package com.example.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.task.model.Users;

@Repository
public interface UsersRepositoryService extends JpaRepository<Users, Long>{

	Users findByemailAndPassword(String email, String password);

}
