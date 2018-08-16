package com.microservice.EmployeeService;

public class MyConstants {

	public static final String API_URL = "/api/employeecrud/";
	
	public static final String EMP_ENDPOINT = "employees";
	
	public static final String ADD_EMP_ENDPOINT = "addEmployee";
	
	public static final String MOD_EMP_ENDPOINT = "updateEmployee";
	
	public static final String ADD_EMP_API_DOC_VALUE = "Register an Employee";
	
	public static final String ADD_EMP_API_DOC_NOTES = "Endpoint to register a new employee. If the employee already exists, "
			+ "the info will be updated with the submitted data.";
	
	public static final String GET_EMP_API_DOC_VALUE = "Find the employee details";
	
	public static final String GET_EMP_API_DOC_NOTES = "It will retrieve the employee details";
	
	public static final String DEL_EMP_API_DOC_VALUE = "Delete the specified employee";
	
	public static final String DEL_EMP_API_DOC_NOTES = "It will delete the employee specified in the request";
	
	public static final String UPD_EMP_API_DOC_VALUE = "Update the specified employee";
	
	public static final String UPD_EMP_API_DOC_NOTES = "It will update the employee specified in the request";
	
	public static final String GET_EMP_ORG_DOC_VALUE = "Find the employee details by organization";
	
	public static final String GET_EMP_ORG_DOC_NOTES = "It will retrieve the employee details by organization";
	
	public static final String GET_EMP_DEP_DOC_VALUE = "Find the employee details by department";
	
	public static final String GET_EMP_DEP_DOC_NOTES = "It will retrieve the employee details by department";
	
}
