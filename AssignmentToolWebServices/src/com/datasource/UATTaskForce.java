package com.datasource;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UATTaskForce")
public class UATTaskForce {
	
	int id;
	People emp_id;
	
	boolean is_in_uat;
	Date uat_start_date;
	Date uat_end_date;
	
	boolean is_ooo;
	Date ooo_start_date;
	Date ooo_end_date;
	
	@Id
    @Column(name = "id")
    @GeneratedValue
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id")
	public People getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(People emp_id) {
		this.emp_id = emp_id;
	}
	public boolean isIs_in_uat() {
		return is_in_uat;
	}
	public void setIs_in_uat(boolean is_in_uat) {
		this.is_in_uat = is_in_uat;
	}
	public Date getUat_start_date() {
		return uat_start_date;
	}
	public void setUat_start_date(Date uat_start_date) {
		this.uat_start_date = uat_start_date;
	}
	public Date getUat_end_date() {
		return uat_end_date;
	}
	public void setUat_end_date(Date uat_end_date) {
		this.uat_end_date = uat_end_date;
	}
	public boolean isIs_ooo() {
		return is_ooo;
	}
	public void setIs_ooo(boolean is_ooo) {
		this.is_ooo = is_ooo;
	}
	public Date getOoo_start_date() {
		return ooo_start_date;
	}
	public void setOoo_start_date(Date ooo_start_date) {
		this.ooo_start_date = ooo_start_date;
	}
	public Date getOoo_end_date() {
		return ooo_end_date;
	}
	public void setOoo_end_date(Date ooo_end_date) {
		this.ooo_end_date = ooo_end_date;
	}	

}
