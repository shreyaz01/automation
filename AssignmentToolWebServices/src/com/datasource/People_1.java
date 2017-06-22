package com.datasource;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "People")
public class People {
	
	int emp_id;
	String emp_name;
	String manager_name;
	String designation;
	
	public People(){}
	public People(int emp_id, String emp_name, String manager_name, String designation )
	{
		this.setEmp_id(emp_id);
		this.setEmp_name(emp_name);
		this.setManager_name(manager_name);
		this.setDesignation(designation);
	}
	
    @Id
    @Column(name = "emp_id")
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
}