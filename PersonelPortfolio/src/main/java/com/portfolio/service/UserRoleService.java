package com.portfolio.service;

import org.springframework.stereotype.Service;

import com.portfolio.domain.impl.UserRole;

@Service
public interface UserRoleService {

	UserRole findByUserRole(String userRole);
	
}
