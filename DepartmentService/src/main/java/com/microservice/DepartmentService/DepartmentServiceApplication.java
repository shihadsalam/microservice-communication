package com.microservice.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.microservice.DepartmentService.model.Department;
import com.microservice.DepartmentService.service.DepartmentService;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class DepartmentServiceApplication implements CommandLineRunner {
	
	@Autowired
	private DepartmentService departmentService;

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Department dep1 = new Department("Development", 1L);
		Department dep2 = new Department("Operations", 1L);
		Department dep3 = new Department("Development", 2L);
		Department dep4 = new Department("Operations", 2L);
		departmentService.add(dep1);
		departmentService.add(dep2);
		departmentService.add(dep3);
		departmentService.add(dep4);
	}
}
