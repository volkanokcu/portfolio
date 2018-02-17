package com.portfolio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.domain.impl.Contact;
import com.portfolio.repository.ContactRepository;
import com.portfolio.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository repository;

	@Override
	public void save(Contact entity) {
		repository.save(entity);
	}

	@Override
	public void update(Contact entity) {
		repository.save(entity);
	}

	@Override
	public void delete(Contact entity) {
		repository.delete(entity);
	}

	@Override
	public List<Contact> findAll() {
		return repository.findAll();
	}

	@Override
	public Contact findById(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public List<Contact> findAll(List<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	


}
