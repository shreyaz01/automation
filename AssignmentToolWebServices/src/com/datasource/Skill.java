package com.datasource;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Skill")
public class Skill {
	
	int skill_id;
	String skill_name;
	String skill_mastery;
	
	public Skill(){}
	public Skill( int skill_id, String skill_name, String skill_mastery )
	{
		this.setSkill_id(skill_id);
		this.setSkill_name(skill_name);
		this.setSkill_mastery(skill_mastery);
	}
	
    @Id
    @Column(name = "skill_id")
    @GeneratedValue
	public int getSkill_id() {
		return skill_id;
	}
	public void setSkill_id(int skill_id) {
		this.skill_id = skill_id;
	}
	public String getSkill_name() {
		return skill_name;
	}
	public void setSkill_name(String skill_name) {
		this.skill_name = skill_name;
	}
	public String getSkill_mastery() {
		return skill_mastery;
	}
	public void setSkill_mastery(String skill_mastery) {
		this.skill_mastery = skill_mastery;
	}
}