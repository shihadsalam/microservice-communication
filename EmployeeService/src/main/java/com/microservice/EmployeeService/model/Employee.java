package com.microservice.EmployeeService.model;

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

@Entity(name = "EMP_EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Emp_Employee_Sequence")
	@SequenceGenerator(name = "Emp_Employee_Sequence", sequenceName = "EMP_EMPLOYEE_SEQ")
	private Long id;
	
	@Column(name = "ORGANIZATION_ID")
	private Long organizationId;
	
	@Column(name = "DEPARTMENT_ID")
	private Long departmentId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "EMP_CODE")
	private String employeeCode;

	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(nullable = false, name = "employee_id")
	private List<Address> address;

	public Employee() {

	}

	public Employee(String name, String employeeCode, Long organizationId, Long departmentId, List<Address> address) {
		this.name = name;
		this.employeeCode = employeeCode;
		this.organizationId = organizationId;
		this.departmentId = departmentId;
		this.address = address;
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
	
	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
	public void update(Employee employee) {
		this.setName(employee.getName());
		this.setEmployeeCode(employee.getEmployeeCode());
		this.setOrganizationId(employee.getOrganizationId());
		this.setDepartmentId(employee.getDepartmentId());
		this.setAddress(employee.getAddress());
	}
	
}
