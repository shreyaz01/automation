package com.datasource;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Task")
public class Task {

	int defect_id;
	String task_type;
	String xtrac_task_id; 
	String severity;
	String business_prioritization;
	String status;
	String assigned_to_app;
	String assigned_to_team;
	String assigned_to_subteam;
	Date estimated_fix_date;

	// custom fields
	People assigned_to_emp1;
	People assigned_to_emp2;
	People assigned_to_emp3;
	String comment_lead;
	String comment_user;
	Date assignment_date;
	boolean is_dnr;
	String est_status;
	
	// last update details
	People updt_by_lead;
	Date updt_timestamp_lead;
	People updt_by_user;
	Date updt_timestamp_user;
	
	
	
	public Task(){}
	
	Task( String task_type,int defect_id, String xtrac_task_id, String severity,
			String business_prioritization, String status,	String assigned_to_app,
			String assigned_to_team,String assigned_to_subteam, Date estimated_fix_date)
	{
		this.setDefect_id(defect_id);
		this.setTask_type(task_type);
		this.setXtrac_task_id(xtrac_task_id);
		this.setSeverity(severity);
		this.setBusiness_prioritization(business_prioritization);
		this.setStatus(status);
		this.setAssigned_to_app(assigned_to_app);
		this.setAssigned_to_team(assigned_to_team);
		this.setAssigned_to_subteam(assigned_to_subteam);
		this.setEstimated_fix_date(estimated_fix_date);
	}
	
	public String getTask_type() {
		return task_type;
	}
	public void setTask_type(String task_type) {
		this.task_type = task_type;
	}
	
    @Id
    @Column(name = "task_id")
	public int getDefect_id() {
		return defect_id;
	}
	public void setDefect_id(int defect_id) {
		this.defect_id = defect_id;
	}
	
	public String getXtrac_task_id() {
		return xtrac_task_id;
	}
	public void setXtrac_task_id(String xtrac_task_id) {
		this.xtrac_task_id = xtrac_task_id;
	}
	
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	
	public String getBusiness_prioritization() {
		return business_prioritization;
	}
	public void setBusiness_prioritization(String business_prioritization) {
		this.business_prioritization = business_prioritization;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getAssigned_to_app() {
		return assigned_to_app;
	}
	public void setAssigned_to_app(String assigned_to_app) {
		this.assigned_to_app = assigned_to_app;
	}
	
	public String getAssigned_to_team() {
		return assigned_to_team;
	}
	public void setAssigned_to_team(String assigned_to_team) {
		this.assigned_to_team = assigned_to_team;
	}
	
	public String getAssigned_to_subteam() {
		return assigned_to_subteam;
	}
	public void setAssigned_to_subteam(String assigned_to_subteam) {
		this.assigned_to_subteam = assigned_to_subteam;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id", insertable=false, updatable=false)
	public People getAssigned_to_emp1() {
		return assigned_to_emp1;
	}
	public void setAssigned_to_emp1(People assigned_to_emp1) {
		this.assigned_to_emp1 = assigned_to_emp1;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id", insertable=false, updatable=false)
	public People getAssigned_to_emp2() {
		return assigned_to_emp2;
	}
	public void setAssigned_to_emp2(People assigned_to_emp2) {
		this.assigned_to_emp2 = assigned_to_emp2;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id", insertable=false, updatable=false)
	public People getAssigned_to_emp3() {
		return assigned_to_emp3;
	}
	public void setAssigned_to_emp3(People assigned_to_emp3) {
		this.assigned_to_emp3 = assigned_to_emp3;
	}

	public Date getAssignment_date() {
		return assignment_date;
	}
	public void setAssignment_date(Date assignment_date) {
		this.assignment_date = assignment_date;
	}
	
	public Date getEstimated_fix_date() {
		return estimated_fix_date;
	}
	public void setEstimated_fix_date(Date estimated_fix_date) {
		this.estimated_fix_date = estimated_fix_date;
	}
	
	public boolean isIs_dnr() {
		return is_dnr;
	}
	public void setIs_dnr(boolean is_dnr) {
		this.is_dnr = is_dnr;
	}

	public String getEst_status() {
		return est_status;
	}
	public void setEst_status(String est_status) {
		this.est_status = est_status;
	}

	public String getComment_lead() {
		return comment_lead;
	}

	public void setComment_lead(String comment_lead) {
		this.comment_lead = comment_lead;
	}

	public String getComment_user() {
		return comment_user;
	}

	public void setComment_user(String comment_user) {
		this.comment_user = comment_user;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id", insertable=false, updatable=false)
	public People getUpdt_by_lead() {
		return updt_by_lead;
	}

	public void setUpdt_by_lead(People updt_by_lead) {
		this.updt_by_lead = updt_by_lead;
	}

	public Date getUpdt_timestamp_lead() {
		return updt_timestamp_lead;
	}

	public void setUpdt_timestamp_lead(Date updt_timestamp_lead) {
		this.updt_timestamp_lead = updt_timestamp_lead;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id", insertable=false, updatable=false)
	public People getUpdt_by_user() {
		return updt_by_user;
	}

	public void setUpdt_by_user(People updt_by_user) {
		this.updt_by_user = updt_by_user;
	}

	public Date getUpdt_timestamp_user() {
		return updt_timestamp_user;
	}

	public void setUpdt_timestamp_user(Date updt_timestamp_user) {
		this.updt_timestamp_user = updt_timestamp_user;
	}
}