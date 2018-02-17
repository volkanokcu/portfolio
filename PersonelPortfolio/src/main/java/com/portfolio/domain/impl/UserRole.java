package com.portfolio.domain.impl;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.portfolio.domain.AbstractEntity;

@Entity
@Table(name="USER_ROLE")
@AttributeOverride(name="id", column=@Column(name="ROLE_ID"))
public class UserRole extends AbstractEntity {
	
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Column(name="USER_ROLE", nullable=false, length=50, unique=true)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
