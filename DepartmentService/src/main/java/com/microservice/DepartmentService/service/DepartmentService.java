package com.microservice.DepartmentService.service;

import java.util.List;

import com.microservice.DepartmentService.model.Department;

public interface DepartmentService {
	
	public Department findById(Long id);
	
	public List<Department> findAll();

	public List<Department> findByOrganization(Long organizationId);

	public Department add(Department department);
}
