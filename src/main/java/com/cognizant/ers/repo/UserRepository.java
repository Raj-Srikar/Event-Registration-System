package com.cognizant.ers.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.ers.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
}
