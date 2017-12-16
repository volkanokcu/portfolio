package com.portfolio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.domain.impl.UserRole;
import com.portfolio.repository.UserRoleRepository;
import com.portfolio.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {
	
	@Autowired
	UserRoleRepository repository;

	@Override
	public UserRole findByUserRole(String userRole) {
		return repository.findByUserRole(userRole);
	}

}
