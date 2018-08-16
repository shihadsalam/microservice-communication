package com.microservice.EmployeeService.service;

import java.util.List;

import com.microservice.EmployeeService.model.Employee;

public interface EmployeeService {

	public Employee findByAddressId(long addressId);

	public Employee addEmployee(Employee employee);
	
	public Employee findEmployeeByName(String name);

	public List<Employee> findByDepartmentId(Long departmentId);

	public List<Employee> findByOrganizationId(Long organizationId);

	public void deleteEmployee(String name);

	public boolean update(Employee employee);

}
