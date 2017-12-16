package com.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.domain.impl.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

	public UserRole findByUserRole(String userRole);
	
}
