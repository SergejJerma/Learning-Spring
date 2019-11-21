package com.serjer.freeter.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serjer.freeter.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
	User findByUsername(String username);

	User findByActivationCode(String code);
}
