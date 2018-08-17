package com.microservice.OrganizationService;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.OrganizationService.model.Department;

@FeignClient(name = "DepartmentService")
public interface DepartmentClient {

	@GetMapping("/get-by-organization/{organizationId}")
	public List<Department> findByOrganization(@PathVariable("organizationId") Long organizationId);
	
	@GetMapping("/get-by-organization-with-employees/{organizationId}")
	public List<Department> findByOrganizationWithEmployees(@PathVariable("organizationId") Long organizationId);
	
}
