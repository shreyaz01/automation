package com.datasource;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PeopleSkill")
public class PeopleSkill {

	int people_skill_id;
	People emp_id;
	Skill skill_id;

	public PeopleSkill() {}
	
	public PeopleSkill(	int people_skill_id, People emp_id, Skill skill_id) 
	{
		this.setPeople_skill_id(people_skill_id);
		this.setEmp_id(emp_id);
		this.setSkill_id(skill_id);
	}
	
    @Id
    @Column(name = "people_skill_id")
    @GeneratedValue
	public int getPeople_skill_id() {
		return people_skill_id;
	}

	public void setPeople_skill_id(int people_skill_id) {
		this.people_skill_id = people_skill_id;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id")
	public People getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(People emp_id) {
		this.emp_id = emp_id;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "skill_id")
	public Skill getSkill_id() {
		return skill_id;
	}

	public void setSkill_id(Skill skill_id) {
		this.skill_id = skill_id;
	}
}
