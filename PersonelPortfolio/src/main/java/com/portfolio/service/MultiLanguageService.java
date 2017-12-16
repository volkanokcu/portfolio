package com.portfolio.service;

import com.porfolio.domain.GenericEntity;

public interface MultiLanguageService<E extends GenericEntity> {
	
	public abstract E findByIdAndLanguage(Integer id, String language);
	
}
