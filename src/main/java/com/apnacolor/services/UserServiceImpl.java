package com.apnacolor.services;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.apnacolor.entity.User;
import com.apnacolor.repository.UserRepository;
import com.apnacolor.request.UserDto;


@Service
public class UserServiceImpl  implements UserDetailsService ,UserService  {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("User not Found....");
		}
		return new org.springframework.security.core.userdetails
				.User(
						user.getUsername(), 
						user.getPassword(), 
				Collections.singletonList(() -> user.getRole()));
	}

	public List<User> getAllUsers() {
	    return userRepository.findAll();
	}
	
	   public UserDto getUserById(Long id) {
	        Optional<User> userOpt = userRepository.findById(id);
	        if (userOpt.isPresent()) {
	            User user = userOpt.get();
	            return new UserDto(user.getId(), user.getUsername());
	        }
	        return null; // or throw custom exception
	    }
	
	public boolean deleteUserById(Long id) {
	    if (userRepository.existsById(id)) {
	        userRepository.deleteById(id);
	        return true;
	    }
	    return false;
	}

	

	
	 
}
