package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employeeman")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "eid")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "dept")
	private String department;
	@Column(name = "proj_assigned")
	private boolean project;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, String department, boolean project) {
		super();
		this.name = name;
		this.department = department;
		this.project = project;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public boolean isProject() {
		return project;
	}

	public void setProject(boolean project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", project=" + project + "]";
	}

}
