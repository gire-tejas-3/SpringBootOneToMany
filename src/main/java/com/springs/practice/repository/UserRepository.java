package com.springs.practice.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springs.practice.model.User;

public interface UserRepository extends JpaRepository<User, Serializable>{
	
	public User getById(Long id);
}
