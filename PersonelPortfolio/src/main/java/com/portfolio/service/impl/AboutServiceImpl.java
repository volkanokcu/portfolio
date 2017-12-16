package com.portfolio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porfolio.domain.impl.About;
import com.portfolio.repository.AboutRepository;
import com.portfolio.service.AboutService;

@Service
public class AboutServiceImpl implements AboutService {
	
	@Autowired
	private AboutRepository repository;

	@Override
	public void save(About entity) {
		repository.save(entity);
	}

	@Override
	public void update(About entity) {
		repository.save(entity);
	}

	@Override
	public void delete(About entity) {
		repository.delete(entity);
	}

	@Override
	public List<About> findAll() {
		return repository.findAll();
	}

	@Override
	public About findById(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public About findByIdAndLanguage(Integer id, String language) {
		return repository.findByIdAndTranslationsLanguageLanguage(id, language);
	}


}
