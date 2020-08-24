package com.healthInsurance.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="ROLES_MASTER")
public class RolesEntity {
	
	@Id
	@GeneratedValue
	@Column(name="ROLE_ID")
	private Integer roleId;
	@Column(name="ROLE_NAME")
	private String roleName;
	
}
