package com.portfolio.domain.impl;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.portfolio.domain.AbstractEntity;

@Entity
@Table(name="PROJECTS_TRANSLATION")
@AttributeOverride(name="id", column=@Column(name="PROJECT_TRANSLATION_ID"))
public class ProjectTranslation extends AbstractEntity {
	
	@Transient
	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="LANGUAGE_ID")
	private Language language;
	
	
	@Column(name="DESCRIPTION")
	private String desription;
	

}
