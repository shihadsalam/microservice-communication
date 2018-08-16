package com.microservice.EmployeeService;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.microservice.EmployeeService.model.Address;
import com.microservice.EmployeeService.model.Employee;
import com.microservice.EmployeeService.service.EmployeeService;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaRepositories(basePackages = { "com.microservice.EmployeeService.repository" })
@EntityScan(basePackages = { "com.microservice.EmployeeService.model" })
public class EmployeeServiceApplication implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceApplication.class);

	@Autowired
	EmployeeService employeeService;
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Employee employee1 = new Employee("Employee1", "Code1", 1L, 2L, buildAddress("Employee1"));
		Employee employee2 = new Employee("Employee2", "Code2", 1L, 2L, buildAddress("Employee2"));
		Employee employee3 = new Employee("Employee3", "Code3", 11L, 22L, buildAddress("Employee3"));
		Employee employee4 = new Employee("Employee4", "Code4", 11L, 22L, buildAddress("Employee4"));
		
		employeeService.addEmployee(employee1);
		employeeService.addEmployee(employee2);
		employeeService.addEmployee(employee3);
		employeeService.addEmployee(employee4);
		
		LOGGER.info("Employees Added");
	}
	
	private List<Address> buildAddress(String empName) {
		List<Address> addresses = new ArrayList<>();
		Address address1 = new Address(1, empName.concat(" Test Address 1"), "695581");
		Address address2 = new Address(2, empName.concat(" Test Address 2"), "691306");
		addresses.add(address1);
		addresses.add(address2);
		return addresses;
	}
}
