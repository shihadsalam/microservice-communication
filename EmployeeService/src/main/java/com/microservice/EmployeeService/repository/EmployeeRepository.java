package com.microservice.EmployeeService.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microservice.EmployeeService.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> { 
	
	public Employee findByAddressId(long addressId);

	public Employee findByName(String name);
	
	public List<Employee> findByDepartmentId(Long departmentId);
	
	public List<Employee> findByOrganizationId(Long organizationId);

}
