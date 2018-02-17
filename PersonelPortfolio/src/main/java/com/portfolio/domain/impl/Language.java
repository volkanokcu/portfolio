package com.portfolio.domain.impl;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.portfolio.domain.AbstractEntity;

@Entity
@Table(name="LANGUAGE")
@AttributeOverride(name="id", column=@Column(name="LANGUAGE_ID"))
public class Language extends AbstractEntity {
	
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Column(name="LANGUAGE", nullable=false, length=50, unique=true)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Language [language=" + name + ", toString()=" + super.toString() + "]";
	}
	
}
