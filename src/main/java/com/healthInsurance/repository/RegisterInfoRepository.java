package com.healthInsurance.repository;

import org.springframework.data.repository.CrudRepository;

import com.healthInsurance.entity.RegisterInfoEntity;

public interface RegisterInfoRepository extends CrudRepository<RegisterInfoEntity, Integer> {

	public RegisterInfoEntity findByPasswordAndEmail(String tempPwd,String email);
	
	public RegisterInfoEntity findByEmailAndPassword(String email, String password); 
}
