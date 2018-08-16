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

@Entity(name = "ORG_ORGANIZATION")
public class Organization {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Org_Organization_Sequence")
	@SequenceGenerator(name = "Org_Organization_Sequence", sequenceName = "ORG_ORGANIZATION_SEQ")
	private Long id;
	
	@Column(name = "NAME")
	private String name;

	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(nullable = false, name = "organization_id")
	private List<Employee> employees;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(nullable = false, name = "organization_id")
	private List<Department> departments;

	public Organization() {

	}

	public Organization(String name) {
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
	
	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public void update(Organization organization) {
		this.setName(organization.getName());
		this.setEmployees(organization.getEmployees());
		this.setDepartments(organization.getDepartments());
	}
	
}
