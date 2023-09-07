package com.cognizant.ers.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.ers.entity.Role;

public interface RoleRepository extends JpaRepository<Role, String> {
	Role findByName(String name);
}
