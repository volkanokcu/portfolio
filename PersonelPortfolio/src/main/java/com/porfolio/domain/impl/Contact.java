package com.porfolio.domain.impl;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.porfolio.domain.AbstractEntity;

@Entity
@Table(name="CONTACT")
@AttributeOverride(name="id", column=@Column(name="CONTACT_ID"))
public class Contact extends AbstractEntity {
	
	@Transient
	private static final long serialVersionUID = 1L;

	@Column(name="PHONE", length=20, nullable=false)
	private String phone;
	
	@Column(name="EMAIL", length=50, nullable=false)
	private String email;
	
	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
