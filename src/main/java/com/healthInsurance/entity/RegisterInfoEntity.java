package com.healthInsurance.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name="REGISTERINFO_ENTITY")
@Data
public class RegisterInfoEntity {

	@Id
	@GeneratedValue
	@Column(name="REGISTER_ID")
	private Integer registerId;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="EMAIL")
	private String email;
	@Column(name="GENDER")
	private Character gender;
	@Column(name="ROLE")
	private String role;
	@Column(name="PASSWORD")
	private String password;
	
	
	@Column(name="CREATED_DATE",updatable=false)
	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	private Date createdDate;
	@Column(name="UPDATED_DATE",insertable=false)
	@Temporal(TemporalType.DATE)
	@UpdateTimestamp
	private Date updatedDate;
	@Column(name="ACTIVE_STATUS")
	private String activeStatus;
	@Column(name="DELETE_SWITCH")
	private Character deleteSwitch;
	
	
}
