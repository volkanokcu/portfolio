package com.portfolio.service;

import com.porfolio.domain.impl.User;

public interface UserService extends GenericService<User> {
	
	User findByUsername(String username);
	
	User findByUsernameAndPassword(String username, String password);
	
}
