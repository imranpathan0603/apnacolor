package com.apnacolor.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.apnacolor.entity.User;
import com.apnacolor.request.UserDto;

public interface UserService {

	public UserDetails loadUserByUsername(String username);
	public List<User> getAllUsers();
	public boolean deleteUserById(Long id);
	 public UserDto getUserById(Long id);
}
