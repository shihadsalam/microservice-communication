package com.microservice.OrganizationService;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.OrganizationService.model.Employee;

@FeignClient(name = "EmployeeService")
public interface EmployeeClient {

	@GetMapping("/get-by-organization/{organizationId}")
	public List<Employee> findByOrganization(@PathVariable("organizationId") Long organizationId);
	
}
