package com.healthInsurance.service;

import java.util.List;
import java.util.Map;

import com.healthInsurance.model.RegisterInfo;

public interface RegisterInfoService {

	public Map<Integer,String> getAllRoles();
	
	public boolean registerAccount(RegisterInfo info);
	
	public RegisterInfo getUserAcctByTempPwd(String tempPwd,String email);
	
	public boolean updateUserInfo(RegisterInfo user);
	
	public boolean loginWithEmailAndPwd(String email, String password);
	
	public List<RegisterInfo> getAllAccounts();
	
	public RegisterInfo getAccountById(Integer id);
	
}
