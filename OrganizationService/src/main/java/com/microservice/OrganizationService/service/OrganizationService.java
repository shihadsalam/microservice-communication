package com.microservice.OrganizationService.service;

import java.util.List;

import com.microservice.OrganizationService.model.Organization;

public interface OrganizationService {
	
	public Organization findById(Long id);
	
	public List<Organization> findAll();

	public Organization add(Organization organization);
}
