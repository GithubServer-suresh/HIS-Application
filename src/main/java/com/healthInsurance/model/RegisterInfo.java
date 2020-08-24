package com.healthInsurance.model;

import java.util.Date;

import lombok.Data;

@Data
public class RegisterInfo {

	
	private Integer registerId;
	private String firstName;
	private String lastName;
	private String email;
	private Character gender;
	private String role;
	private String password;
	private Date createdDate;
	private Date updatedDate;
	private String activeStatus;
	private Character deleteSwitch;
}
