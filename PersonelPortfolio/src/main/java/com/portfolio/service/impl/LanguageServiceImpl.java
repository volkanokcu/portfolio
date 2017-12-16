package com.portfolio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porfolio.domain.impl.Language;
import com.portfolio.repository.LanguageRepository;
import com.portfolio.service.LanguageService;

@Service
public class LanguageServiceImpl implements LanguageService {
	
	@Autowired
	LanguageRepository repository;

	@Override
	public void save(Language entity) {
		repository.save(entity);
	}

	@Override
	public void update(Language entity) {
		repository.save(entity);
	}

	@Override
	public void delete(Language entity) {
		repository.delete(entity);
	}

	@Override
	public List<Language> findAll() {
		return repository.findAll();
	}

	@Override
	public Language findById(Integer id) {
		return repository.findOne(id);
	}

}
