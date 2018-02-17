package com.portfolio.repository;

import org.springframework.data.jpa.repository.Query;

import com.portfolio.domain.GenericEntity;


public interface MultiLanguageRepository <E extends GenericEntity> {
	
	@Query("select e from #{#entityName} e join fetch e.translations t where e.id = ?1 and t.language.name = ?2 ")
	E findByIdAndLanguageName(Integer id, String languageName);
	
}
