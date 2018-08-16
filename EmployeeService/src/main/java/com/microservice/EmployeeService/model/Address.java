package com.microservice.EmployeeService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "EMP_ADDRESS")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Emp_Address_Sequence")
	@SequenceGenerator(name = "Emp_Address_Sequence", sequenceName = "EMP_ADDR_SEQ")
	private Long id;

	@Column(name = "HOUSE_NUMBER")
	private int houseNumber;

	@Column(name = "STREET")
	private String street;

	@Column(name = "PIN_CODE")
	private String pinCode;
	

	public Address() {

	}
	
	public Address(int houseNumber, String street, String pinCode) {
		this.houseNumber = houseNumber;
		this.street = street;
		this.pinCode = pinCode;
	}

	public Long getId() {
		return id;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

}
