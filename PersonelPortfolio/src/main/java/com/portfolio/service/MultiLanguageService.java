package com.portfolio.service;

import com.portfolio.domain.GenericEntity;

public interface MultiLanguageService<E extends GenericEntity> {
	
	public abstract E findByIdAndLanguage(Integer id, String language);
	
}
