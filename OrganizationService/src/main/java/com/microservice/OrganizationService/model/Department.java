package com.microservice.OrganizationService.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity(name = "ORG_DEPARTMENT")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Org_Department_Sequence")
	@SequenceGenerator(name = "Org_Department_Sequence", sequenceName = "ORG_DEPARTMENT_SEQ")
	private Long id;
	
	@Column(name = "NAME")
	private String name;

	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(nullable = false, name = "department_id")
	private List<Employee> employees;

	public Department() {

	}

	public Department(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public void update(Department department) {
		this.setName(department.getName());
		this.setEmployees(department.getEmployees());
	}
	
}
