package com.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.porfolio.domain.impl.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String userName);
	
	User findByUsernameAndPassword(String username, String password);
	
}
