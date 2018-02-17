package com.portfolio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.domain.impl.User;
import com.portfolio.repository.UserRepository;
import com.portfolio.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository repository;

	@Override
	public void save(User entity) {
		repository.save(entity);
	}
	
	@Override
	public void save(List<User> entities) {
		repository.save(entities);
	}

	@Override
	public void update(User entity) {
		repository.save(entity);
		
	}

	@Override
	public void delete(User entity) {
		repository.delete(entity);
	}

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findById(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public User findByUsername(String username) {
		return repository.findByUsername(username);
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		return repository.findByUsernameAndPassword(username, password);
	}

	@Override
	public List<User> findAll(List<Integer> ids) {
		return repository.findAll(ids);
	}


}
