package com.microservice.OrganizationService.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.microservice.OrganizationService.model.Organization;

public interface OrganizationRepository extends CrudRepository<Organization, Long>{

	public List<Organization> findAll();
	
}