package com.microservice.DepartmentService.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.DepartmentService.Constants;
import com.microservice.DepartmentService.EmployeeClient;
import com.microservice.DepartmentService.model.Department;
import com.microservice.DepartmentService.service.DepartmentService;

import io.swagger.annotations.ApiOperation;


@RestController
@RefreshScope
public class DepartmentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	DepartmentService departmentService;
	
	@Autowired
	EmployeeClient employeeClient;
	
	
	@ApiOperation(value = Constants.ADD_DEP_DOC, nickname = Constants.ADD_DEP_DOC, notes = Constants.ADD_DEP_DOC)
	@PostMapping("/add-department")
	public Department add(@RequestBody Department department) {
		LOGGER.info("Department add: {}", department);
		return departmentService.add(department);
	}
	
	@ApiOperation(value = Constants.GET_ALL_DEP_DOC, nickname = Constants.GET_ALL_DEP_DOC, notes = Constants.GET_ALL_DEP_DOC)
	@GetMapping("/get-all-departments")
	@ResponseBody
	public List<Department> findAll() {
		LOGGER.info("Department find");
		return departmentService.findAll();
	}
	
	@ApiOperation(value = Constants.GET_DEP_DOC, nickname = Constants.GET_DEP_DOC, notes = Constants.GET_DEP_DOC)
	@GetMapping("get-department/{id}")
	@ResponseBody
	public Department findById(@PathVariable("id") Long id) {
		LOGGER.info("Department find: id={}", id);
		return departmentService.findById(id);
	}
	
	@ApiOperation(value = Constants.GET_DEP_ORG_DOC, nickname = Constants.GET_DEP_ORG_DOC, notes = Constants.GET_DEP_ORG_DOC)
	@GetMapping("/get-by-organization/{organizationId}")
	@ResponseBody
	public List<Department> findByOrganization(@PathVariable("organizationId") Long organizationId) {
		LOGGER.info("Department find: organizationId={}", organizationId);
		return departmentService.findByOrganization(organizationId);
	}
	
	@ApiOperation(value = Constants.GET_DEP_ORG_EMP_DOC, nickname = Constants.GET_DEP_ORG_EMP_DOC, notes = Constants.GET_DEP_ORG_EMP_DOC)
	@GetMapping("/get-by-organization-with-employees/{organizationId}")
	@ResponseBody
	public List<Department> findByOrganizationWithEmployees(@PathVariable("organizationId") Long organizationId) {
		LOGGER.info("Department find with employees: organizationId={}", organizationId);
		List<Department> departments = departmentService.findByOrganization(organizationId);
		departments.forEach(d -> d.setEmployees(employeeClient.findByDepartment(d.getId())));
		return departments;
	}
	
}