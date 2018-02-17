package com.portfolio.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.domain.impl.Project;
import com.portfolio.repository.ProjectRepository;
import com.portfolio.service.ProjectService;

@Service
public class ProjectsServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectRepository repository;

	@Override
	public void save(Project entity) {
		repository.save(entity);
	}

	@Override
	public void update(Project entity) {
		repository.save(entity);
	}

	@Override
	public void delete(Project entity) {
		repository.delete(entity);
	}

	@Override
	public List<Project> findAll() {
		return repository.findAll();
	}

	@Override
	public Project findById(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public List<Project> findAll(List<Integer> ids) {
		return repository.findAll();
	}

	@Override
	public Project findByIdAndLanguage(Integer id, String languageName) {
		return repository.findByIdAndLanguageName(id, languageName);
	}


}
