package com.microservice.DepartmentService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.DepartmentService.model.Department;
import com.microservice.DepartmentService.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	@Transactional
	public Department findById(Long id) {
		Optional<Department> department = departmentRepository.findById(id);
		if(department.isPresent()) {
			return department.get();
		}
		return null; 
	}

	@Override
	@Transactional
	public List<Department> findAll() {
		return departmentRepository.findAll();
	}

	@Override
	@Transactional
	public List<Department> findByOrganization(Long organizationId) {
		return departmentRepository.findByOrganizationId(organizationId);
	}

	@Override
	@Transactional
	public Department add(Department department) {
		return departmentRepository.save(department);
	}
	
}
