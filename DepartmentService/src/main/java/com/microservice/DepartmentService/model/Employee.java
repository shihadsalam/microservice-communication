package com.microservice.DepartmentService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "DEP_EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Dep_Employee_Sequence")
	@SequenceGenerator(name = "Dep_Employee_Sequence", sequenceName = "DEP_EMPLOYEE_SEQ")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "EMP_CODE")
	private String employeeCode;

	public Employee() {

	}

	public Employee(String name, String employeeCode) {
		this.name = name;
		this.employeeCode = employeeCode;
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

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	
	public void update(Employee employee) {
		this.setName(employee.getName());
		this.setEmployeeCode(employee.getEmployeeCode());
	}
	
}
