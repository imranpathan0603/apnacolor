package com.apnacolor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apnacolor.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
