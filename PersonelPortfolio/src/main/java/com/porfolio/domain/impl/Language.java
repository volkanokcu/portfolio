package com.porfolio.domain.impl;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.porfolio.domain.AbstractEntity;

@Entity
@Table(name="LANGUAGE")
@AttributeOverride(name="id", column=@Column(name="LANGUAGE_ID"))
public class Language extends AbstractEntity {
	
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Column(name="LANGUAGE", nullable=false, length=50, unique=true)
	private String language;

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "Language [language=" + language + ", toString()=" + super.toString() + "]";
	}
	
}
