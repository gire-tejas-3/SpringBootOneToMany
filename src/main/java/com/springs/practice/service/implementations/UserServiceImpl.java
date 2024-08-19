package com.springs.practice.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springs.practice.exception.UserNotFoundException;
import com.springs.practice.model.Address;
import com.springs.practice.model.User;
import com.springs.practice.repository.UserRepository;
import com.springs.practice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long id) {
		User u = userRepository.getById(id);
		if (u == null) {
			throw new UserNotFoundException("User is not found with id: " + id);
		}

		return u;
	}

	@Override
	public User updateUser(Long id, User user) {
		User exsistingUser = userRepository.getById(id);
		Address exsistingAddress = exsistingUser.getAddress();

		if (exsistingUser == null) {
			throw new UserNotFoundException("User Not Found with id: " + id);
		}
		exsistingUser.setUsername(user.getUsername());
		exsistingUser.setPassword(user.getPassword());
		exsistingUser.setEmail(user.getEmail());
		exsistingUser.setMobileNo(user.getMobileNo());
		exsistingUser.setName(user.getName());
		exsistingAddress.setAddId(user.getAddress().getAddId());
		exsistingAddress.setCity(user.getAddress().getCity());
		exsistingAddress.setState(user.getAddress().getState());
		exsistingUser.setAddress(exsistingAddress);
		return userRepository.save(exsistingUser);
	}

	@Override
	public void deleteUserById(Long id) {

		if (!userRepository.existsById(id)) {
			throw new UserNotFoundException("User is not found with id: " + id);
		}
		userRepository.deleteById(id);
	}

}
