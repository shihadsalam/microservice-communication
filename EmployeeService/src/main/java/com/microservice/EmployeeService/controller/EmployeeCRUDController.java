package com.microservice.EmployeeService.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.EmployeeService.Constants;
import com.microservice.EmployeeService.model.Employee;
import com.microservice.EmployeeService.service.EmployeeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RefreshScope
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeCRUDController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeCRUDController.class);
	
	@Autowired
	EmployeeService employeeService;
	
	@ApiOperation(value = Constants.GET_EMP_DOC, nickname = Constants.GET_EMP_DOC, notes = Constants.GET_EMP_NOTES)
	@GetMapping("/get-employee/{name}")
	@ResponseBody
	public HttpEntity<Employee> getEmployeeDetails(@PathVariable String name) {
		HttpStatus httpStatus = HttpStatus.OK;
		Employee retrievedEmployee = null;
		try {
			retrievedEmployee = employeeService.findEmployeeByName(name);
			LOGGER.info("Employee Retrieved :: " + retrievedEmployee.getName());
		}
		catch (Exception ex) {
			LOGGER.info("Error while retrieving Employee :: " + ex);
			httpStatus = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<>(retrievedEmployee, httpStatus);
	}
	
	@ApiOperation(value = Constants.GET_EMP_DEP_DOC, nickname = Constants.GET_EMP_DEP_DOC, notes = Constants.GET_EMP_DEP_NOTES)
	@GetMapping("/get-by-department/{departmentId}")
	@ResponseBody
	public List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId) {
		LOGGER.info("Employee find: departmentId={}", departmentId);
		return employeeService.findByDepartmentId(departmentId);
	}
	
	@ApiOperation(value = Constants.GET_EMP_ORG_DOC, nickname = Constants.GET_EMP_ORG_DOC, notes = Constants.GET_EMP_ORG_NOTES)
	@GetMapping("/get-by-organization/{organizationId}")
	@ResponseBody
	public List<Employee> findByOrganization(@PathVariable("organizationId") Long organizationId) {
		LOGGER.info("Employee find: organizationId={}", organizationId);
		return employeeService.findByOrganizationId(organizationId);
	}
	
	@ApiOperation(value = Constants.ADD_EMP_DOC, nickname = Constants.ADD_EMP_DOC, notes = Constants.ADD_EMP_NOTES)
	@PostMapping(value = "/add-employee", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpEntity<Employee> registerEmployee(@RequestBody Employee employee) {
		HttpStatus httpStatus = HttpStatus.OK;
		Employee addedEmployee = null;
		try {
			addedEmployee = employeeService.addEmployee(employee);
			LOGGER.info("Employee Added :: " + addedEmployee.getName());
		}
		catch (Exception ex) {
			LOGGER.info("Error while adding Employee :: " + ex);
			httpStatus = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<Employee>(addedEmployee, httpStatus);
	}

	@ApiOperation(value = Constants.DEL_EMP_DOC, nickname = Constants.DEL_EMP_DOC, notes = Constants.DEL_EMP_NOTES)
	@DeleteMapping("/delete-employee/{name}")
	@ResponseBody
	public HttpEntity<Void> deleteEmployee(@PathVariable String name) {
		HttpStatus httpStatus = HttpStatus.OK;
		try {
			employeeService.deleteEmployee(name);
			LOGGER.info("Employee Added :: " + name);
		}
		catch (Exception ex) {
			LOGGER.info("Error while deleting Employee :: " + ex);
			httpStatus = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<>(httpStatus);
	}
	
    @ApiOperation(value = Constants.UPD_EMP_DOC, nickname = Constants.UPD_EMP_DOC, notes = Constants.UPD_EMP_NOTES)
    @PutMapping("/update-employee")
    @ResponseBody
    public HttpEntity<Void> updateEmployee(@RequestBody Employee employee) {
		HttpStatus httpStatus = HttpStatus.OK;
		try {
			boolean isUpdated = employeeService.update(employee);
			if(isUpdated) {
				LOGGER.info("Employee Updated :: " + employee.getName());
			}
			else {
				LOGGER.info("Employee Added :: " + employee.getName());
			}
		}
		catch (Exception ex) {
			LOGGER.info("Error while updating Employee :: " + ex);
			httpStatus = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<>(httpStatus);
    }

}
