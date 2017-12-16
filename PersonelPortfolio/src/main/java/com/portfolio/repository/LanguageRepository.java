package com.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.domain.impl.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer>{

	
}
