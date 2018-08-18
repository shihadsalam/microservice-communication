package com.microservice.OrganizationService.controller;

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

import com.microservice.OrganizationService.Constants;
import com.microservice.OrganizationService.DepartmentClient;
import com.microservice.OrganizationService.EmployeeClient;
import com.microservice.OrganizationService.model.Organization;
import com.microservice.OrganizationService.service.OrganizationService;

import io.swagger.annotations.ApiOperation;


@RestController
@RefreshScope
public class OrganizationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationController.class);
	
	@Autowired
	OrganizationService organizationService;
	
	@Autowired
	DepartmentClient departmentClient;
	
	@Autowired
	EmployeeClient employeeClient;
	
	@ApiOperation(value = Constants.ADD_ORG_DOC, nickname = Constants.ADD_ORG_DOC, notes = Constants.ADD_ORG_DOC)
	@PostMapping("/add-organizations")
	public Organization add(@RequestBody Organization organization) {
		LOGGER.info("Organization add: {}", organization);
		return organizationService.add(organization);
	}
	
	@ApiOperation(value = Constants.GET_ALL_ORG_DOC, nickname = Constants.GET_ALL_ORG_DOC, notes = Constants.GET_ALL_ORG_DOC)
	@GetMapping("/get-all-organizations")
	@ResponseBody
	public List<Organization> findAll() {
		LOGGER.info("Organization find");
		return organizationService.findAll();
	}
	
	@ApiOperation(value = Constants.GET_ORG_DOC, nickname = Constants.GET_ORG_DOC, notes = Constants.GET_ORG_DOC)
	@GetMapping("get-organization/{id}")
	@ResponseBody
	public Organization findById(@PathVariable("id") Long id) {
		LOGGER.info("Organization find: id={}", id);
		return organizationService.findById(id);
	}

	@ApiOperation(value = Constants.GET_ORG_DEP_DOC, nickname = Constants.GET_ORG_DEP_DOC, notes = Constants.GET_ORG_DEP_DOC)
	@GetMapping("get-organization-with-departments/{id}")
	@ResponseBody
	public Organization findByIdWithDepartments(@PathVariable("id") Long id) {
		LOGGER.info("Organization find: id={}", id);
		Organization organization = organizationService.findById(id);
		organization.setDepartments(departmentClient.findByOrganization(organization.getId()));
		return organization;
	}
	
	@ApiOperation(value = Constants.GET_ORG_DEP_EMP_DOC, nickname = Constants.GET_ORG_DEP_EMP_DOC, notes = Constants.GET_ORG_DEP_EMP_DOC)
	@GetMapping("get-organization-with-departments-and-employees/{id}")
	@ResponseBody
	public Organization findByIdWithDepartmentsAndEmployees(@PathVariable("id") Long id) {
		LOGGER.info("Organization find: id={}", id);
		Organization organization = organizationService.findById(id);
		organization.setDepartments(departmentClient.findByOrganizationWithEmployees(organization.getId()));
		return organization;
	}
	
	@ApiOperation(value = Constants.GET_ORG_EMP_DOC, nickname = Constants.GET_ORG_EMP_DOC, notes = Constants.GET_ORG_EMP_DOC)
	@GetMapping("get-organization-with-employees/{id}")
	@ResponseBody
	public Organization findByIdWithEmployees(@PathVariable("id") Long id) {
		LOGGER.info("Organization find: id={}", id);
		Organization organization = organizationService.findById(id);
		organization.setEmployees(employeeClient.findByOrganization(organization.getId()));
		return organization;
	}
	
}