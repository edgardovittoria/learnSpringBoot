package com.manning.readingList.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manning.readingList.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByUsername(String username);

}
