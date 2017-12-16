package com.portfolio.repository;

import org.springframework.data.jpa.repository.Query;

import com.porfolio.domain.GenericEntity;


public interface MultiLanguageRepository <E extends GenericEntity> {
	
	@Query("select e from #{#entityName} e join fetch e.translations t where e.id = ?1 and t.language.language = ?2 ")
	E findByIdAndLanguage(Integer id, String language);
	
	E findByIdAndTranslationsLanguageLanguage(Integer id, String language);
}
