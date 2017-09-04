package com.udemy.backendninja.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name = "username", unique = true, nullable = false, length = 45)
	private String username;

	@Column(name = "password", nullable = false, length = 60)
	private String passoword;

	@Column(name = "enable", nullable = false)
	private boolean enable;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private Set<UserRole> userRole = new HashSet<>();

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String username, String passoword, boolean enable) {
		super();
		this.username = username;
		this.passoword = passoword;
		this.enable = enable;
	}

	public User(String username, String passoword, boolean enable, Set<UserRole> userRole) {
		super();
		this.username = username;
		this.passoword = passoword;
		this.enable = enable;
		this.userRole = userRole;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassoword() {
		return passoword;
	}

	public void setPassoword(String passoword) {
		this.passoword = passoword;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Set<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", passoword=" + passoword + ", enable=" + enable + ", userRole="
				+ userRole + "]";
	}

}
