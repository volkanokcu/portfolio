package com.portfolio.service.impl;

import java.util.List;

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
		return repository.findByName(userRole);
	}

	@Override
	public void save(UserRole entity) {
		repository.save(entity);
	}

	@Override
	public void update(UserRole entity) {
		repository.save(entity);
	}

	@Override
	public void delete(UserRole entity) {
		repository.save(entity);
		
	}

	@Override
	public List<UserRole> findAll() {
		return repository.findAll();
	}

	@Override
	public UserRole findById(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public List<UserRole> findAll(List<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

}
