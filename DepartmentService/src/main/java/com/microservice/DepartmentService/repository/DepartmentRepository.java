package com.microservice.DepartmentService.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.microservice.DepartmentService.model.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long>{

	public List<Department> findAll();
	
	public List<Department> findByOrganizationId(Long organizationId);
	
}