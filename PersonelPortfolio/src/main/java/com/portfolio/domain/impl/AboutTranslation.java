package com.portfolio.domain.impl;

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
@Table(name="ABOUT_TRANSLATION")
@AttributeOverride(name="id", column=@Column(name="ABOUT_TRANSLATION_ID"))
public class AboutTranslation extends AbstractEntity {
	
	@Transient
	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="LANGUAGE_ID")
	private Language language;
	
	@Column(name="DESCRIPTION", length=3000, nullable=false)
	private String description;

	public Language getLanguage() {
		return language;
	}

	public String getDescription() {
		return description;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "AboutTranslation [language=" + language + ", description=" + description + ", toString()="
				+ super.toString() + "]";
	}
	
}
