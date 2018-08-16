package com.microservice.OrganizationService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.OrganizationService.model.Organization;
import com.microservice.OrganizationService.repository.OrganizationRepository;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationRepository organizationRepository;

	@Override
	@Transactional
	public Organization findById(Long id) {
		Optional<Organization> organization = organizationRepository.findById(id);
		if(organization.isPresent()) {
			return organization.get();
		}
		return null; 
	}

	@Override
	@Transactional
	public List<Organization> findAll() {
		return organizationRepository.findAll();
	}

	@Override
	@Transactional
	public Organization add(Organization organization) {
		return organizationRepository.save(organization);
	}
	
}
