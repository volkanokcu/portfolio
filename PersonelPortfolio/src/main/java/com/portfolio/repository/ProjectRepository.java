package com.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.domain.impl.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>, MultiLanguageRepository<Project> {

}
