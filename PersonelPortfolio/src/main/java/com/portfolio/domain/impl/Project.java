package com.portfolio.domain.impl;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.portfolio.domain.AbstractEntity;

@Entity
@Table(name="PROJECTS")
@AttributeOverride(name="id", column=@Column(name="PROJECT_ID"))
public class Project extends AbstractEntity {
	
	@Transient
	private static final long serialVersionUID = 1L;

	@Column(name="PROJECT_NAME", length=50, nullable=false)
	private String projectName;
	
	@Column(name="APP_PLATFORM", length=50, nullable=false)
	private String appPlatform;
	
	@ElementCollection
	private List<String> programmingLanguages;
	
	@Column(name="DESCRIPTION")
	private String desription;


}
