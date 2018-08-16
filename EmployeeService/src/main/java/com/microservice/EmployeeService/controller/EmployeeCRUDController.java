package com.microservice.EmployeeService.controller;

import java.util.ArrayList;
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

import com.microservice.EmployeeService.MyConstants;
import com.microservice.EmployeeService.model.Employee;
import com.microservice.EmployeeService.service.EmployeeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RefreshScope
@RequestMapping(value = MyConstants.API_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeCRUDController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeCRUDController.class);
	
	@Autowired
	EmployeeService employeeService;
	
	@ApiOperation(value = MyConstants.GET_EMP_API_DOC_VALUE, nickname = MyConstants.GET_EMP_API_DOC_VALUE, notes = MyConstants.GET_EMP_API_DOC_NOTES)
	@GetMapping(MyConstants.EMP_ENDPOINT + "/{name}")
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
	
	@ApiOperation(value = MyConstants.GET_EMP_DEP_DOC_VALUE, nickname = MyConstants.GET_EMP_DEP_DOC_VALUE, notes = MyConstants.GET_EMP_DEP_DOC_NOTES)
	@GetMapping("/department/{departmentId}")
	@ResponseBody
	public HttpEntity<List<Employee>> findByDepartment(@PathVariable("departmentId") Long departmentId) {
		LOGGER.info("Employee find: departmentId={}", departmentId);
		HttpStatus httpStatus = HttpStatus.OK;
		List<Employee> employees = new ArrayList<>();
		try {
			employees = employeeService.findByDepartmentId(departmentId);
		}
		catch (Exception ex) {
			LOGGER.info("Error while find by Department :: " + ex);
			httpStatus = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<List<Employee>>(employees, httpStatus);
	}
	
	@ApiOperation(value = MyConstants.GET_EMP_ORG_DOC_VALUE, nickname = MyConstants.GET_EMP_ORG_DOC_VALUE, notes = MyConstants.GET_EMP_ORG_DOC_NOTES)
	@GetMapping("/organization/{organizationId}")
	@ResponseBody
	public HttpEntity<List<Employee>> findByOrganization(@PathVariable("organizationId") Long organizationId) {
		LOGGER.info("Employee find: organizationId={}", organizationId);
		HttpStatus httpStatus = HttpStatus.OK;
		List<Employee> employees = new ArrayList<>();
		try {
			employees = employeeService.findByOrganizationId(organizationId);
		}
		catch (Exception ex) {
			LOGGER.info("Error while find by Organization :: " + ex);
			httpStatus = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<List<Employee>>(employees, httpStatus);
	}
	
	@ApiOperation(value = MyConstants.ADD_EMP_API_DOC_VALUE, nickname = MyConstants.ADD_EMP_API_DOC_VALUE, notes = MyConstants.ADD_EMP_API_DOC_NOTES)
	@PostMapping(value = MyConstants.ADD_EMP_ENDPOINT, consumes = MediaType.APPLICATION_JSON_VALUE)
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

	@ApiOperation(value = MyConstants.DEL_EMP_API_DOC_VALUE, nickname = MyConstants.DEL_EMP_API_DOC_VALUE, notes = MyConstants.DEL_EMP_API_DOC_NOTES)
	@DeleteMapping(MyConstants.EMP_ENDPOINT + "/{name}")
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
	
    @ApiOperation(value = MyConstants.UPD_EMP_API_DOC_VALUE, nickname = MyConstants.UPD_EMP_API_DOC_VALUE, notes = MyConstants.UPD_EMP_API_DOC_NOTES)
    @PutMapping(MyConstants.MOD_EMP_ENDPOINT)
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
