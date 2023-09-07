package com.cognizant.ers.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.ers.entity.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, String> {
	Privilege findByName(String name);
}
