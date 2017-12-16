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
@Table(name="ABOUT")
@AttributeOverride(name="id", column=@Column(name="ABOUT_ID"))
public class About extends AbstractEntity {
	
	@Transient
	private static final long serialVersionUID = 1L;

	@Column(name="FIRST_NAME", length=50, nullable=false)
	private String firstName;
	
	@Column(name="LAST_NAME", length=50, nullable=false)
	private String lastName;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="ABOUT_ID")
	private List<AboutTranslation> translations;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public List<AboutTranslation> getTranslations() {
		return translations;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setTranslations(List<AboutTranslation> translations) {
		this.translations = translations;
	}

	@Override
	public String toString() {
		return "About [firstName=" + firstName + ", lastName=" + lastName + ", translations=" + translations
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
