package com.portfolio.domain.impl;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.portfolio.domain.AbstractEntity;

@Entity
@Table(name="PROJECTS")
@AttributeOverride(name="id", column=@Column(name="PROJECT_ID"))
public class Project extends AbstractEntity {
	
	@Transient
	private static final long serialVersionUID = 1L;

	@Column(name="PROJECT_NAME", length=50, nullable=false, unique=true)
	private String projectName;
	
	@Column(name="APP_PLATFORM", length=50, nullable=false)
	private String appPlatform;
	
	@Column(name="PROGRAMMING_LANGUAGES", length=500, nullable=false)
	private String programmingLanguages;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="PROJECT_ID")
	private List<ProjectTranslation> translations;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getAppPlatform() {
		return appPlatform;
	}

	public void setAppPlatform(String appPlatform) {
		this.appPlatform = appPlatform;
	}

	public String getProgrammingLanguages() {
		return programmingLanguages;
	}

	public void setProgrammingLanguages(String programmingLanguages) {
		this.programmingLanguages = programmingLanguages;
	}

	public List<ProjectTranslation> getTranslations() {
		return translations;
	}

	public void setTranslations(List<ProjectTranslation> translations) {
		this.translations = translations;
	}


}
