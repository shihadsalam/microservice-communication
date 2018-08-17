package com.microservice.DepartmentService;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.DepartmentService.model.Employee;

@FeignClient(name = "EmployeeService")
public interface EmployeeClient {

	@GetMapping("/get-by-department/{departmentId}")
	public List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId);
	
}
