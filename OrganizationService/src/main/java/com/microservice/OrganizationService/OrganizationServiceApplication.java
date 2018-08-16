package com.microservice.OrganizationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.microservice.OrganizationService.model.Organization;
import com.microservice.OrganizationService.service.OrganizationService;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrganizationServiceApplication implements CommandLineRunner {
	
	@Autowired
	private OrganizationService organizationService;

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Organization org1 = new Organization("TCS");
		Organization org2 = new Organization("CTS");
		Organization org3 = new Organization("HCL");
		
		organizationService.add(org1);
		organizationService.add(org2);
		organizationService.add(org3);
	}
}
