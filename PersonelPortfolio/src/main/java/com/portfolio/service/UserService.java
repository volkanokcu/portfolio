package com.portfolio.service;

import java.util.List;

import com.portfolio.domain.impl.User;

public interface UserService extends GenericService<User> {
	
	User findByUsername(String username);
	
	User findByUsernameAndPassword(String username, String password);
	
	void save(List<User> entities);
	
}
