package com.manning.readingList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.manning.readingList.domain.Reader;

public interface ReaderRepository extends JpaRepository<Reader, String>{

	UserDetails findByUsername(String username);


}
