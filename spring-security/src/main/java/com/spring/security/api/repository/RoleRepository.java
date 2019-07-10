package com.spring.security.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.security.api.model.Role;

public interface RoleRepository extends JpaRepository<Role , Integer>{

}
