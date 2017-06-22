package com.datasource;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EnvironmentDetails")
public class EnvironmentDetails {
	
	String env_name;
	String username;
	String password;
	String description;
	
	@Id
    @Column(name = "env_name")
	public String getEnv_name() {
		return env_name;
	}
	public void setEnv_name(String env_name) {
		this.env_name = env_name;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
