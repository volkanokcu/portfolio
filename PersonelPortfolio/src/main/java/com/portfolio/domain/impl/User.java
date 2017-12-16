package com.portfolio.domain.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.portfolio.domain.AbstractEntity;

@Entity
@Table(name="USER")
@AttributeOverride(name="id", column=@Column(name="USER_ID"))
public class User extends AbstractEntity implements UserDetails {

	@Transient
	private static final long serialVersionUID = 1L;

	@Column(name="USERNAME", nullable=false, length=50)
	private String username;
	
	@Column(name="PASSWORD", nullable=false, length=250)
	private String password;
	
	@Column(name="ENABLED", nullable=false, length=50)
	private boolean enabled = true;
	
	@Column(name="CREDENTIALS_NON_EXPİRED", nullable=false, length=50)
	private boolean credentialsNonExpired = true;
	
	@Column(name="ACCOUNT_NON_EXPIRED", nullable=false, length=50)
	private boolean accountNonExpired = true;
	
	@Column(name="ACCOUNT_NON_LOCKED", nullable=false, length=50)
	private boolean accountNonLocked = true;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="USER_ROLES", joinColumns = @JoinColumn(name="USER_ID",referencedColumnName="USER_ID"), 
	inverseJoinColumns=@JoinColumn(name="ROLE_ID", referencedColumnName="ROLE_ID"))
	private Set<UserRole> userRoles;
	
	@Override
	public String getUsername() {
		return username;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	
	@Override
	public boolean isEnabled() {
		return enabled;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for(UserRole role : getUserRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getUserRole()));
		}
		return grantedAuthorities;
	}

}
