package com.springs.practice.service;

import com.springs.practice.model.User;

public interface UserService {

//	Save
	public User saveUser(User user);

//  Get
	public User getUserById(Long id);
	
//  Update
	public User updateUser(Long id, User user);

	public void deleteUserById(Long id);
}
