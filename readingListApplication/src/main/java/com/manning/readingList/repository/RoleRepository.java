package com.manning.readingList.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manning.readingList.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
