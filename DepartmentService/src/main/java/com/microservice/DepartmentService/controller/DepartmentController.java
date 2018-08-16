package com.microservice.DepartmentService.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.DepartmentService.EmployeeClient;
import com.microservice.DepartmentService.model.Department;
import com.microservice.DepartmentService.service.DepartmentService;


@RestController
public class DepartmentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	DepartmentService departmentService;
	
	@Autowired
	EmployeeClient employeeClient;
	
	@PostMapping("/")
	public Department add(@RequestBody Department department) {
		LOGGER.info("Department add: {}", department);
		return departmentService.add(department);
	}
	
	@GetMapping("/{id}")
	public Department findById(@PathVariable("id") Long id) {
		LOGGER.info("Department find: id={}", id);
		return departmentService.findById(id);
	}
	
	@GetMapping("/")
	public List<Department> findAll() {
		LOGGER.info("Department find");
		return departmentService.findAll();
	}
	
	@GetMapping("/organization/{organizationId}")
	public List<Department> findByOrganization(@PathVariable("organizationId") Long organizationId) {
		LOGGER.info("Department find: organizationId={}", organizationId);
		return departmentService.findByOrganization(organizationId);
	}
	
	@GetMapping("/organization/{organizationId}/with-employees")
	public List<Department> findByOrganizationWithEmployees(@PathVariable("organizationId") Long organizationId) {
		LOGGER.info("Department find with employees: organizationId={}", organizationId);
		List<Department> departments = departmentService.findByOrganization(organizationId);
		departments.forEach(d -> d.setEmployees(employeeClient.findByDepartment(d.getId())));
		return departments;
	}
	
}