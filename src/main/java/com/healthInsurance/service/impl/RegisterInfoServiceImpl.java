package com.healthInsurance.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthInsurance.entity.RegisterInfoEntity;
import com.healthInsurance.entity.RolesEntity;
import com.healthInsurance.model.RegisterInfo;
import com.healthInsurance.repository.RegisterInfoRepository;
import com.healthInsurance.repository.RolesRepository;
import com.healthInsurance.service.RegisterInfoService;
import com.healthInsurance.utils.EmailUtils;
import com.healthInsurance.utils.PwdUtils;

@Service
public class RegisterInfoServiceImpl implements RegisterInfoService {


	@Autowired
	private RolesRepository rolesRepo;

	@Autowired
	private RegisterInfoRepository registerRepository;


	@Autowired
	private EmailUtils emailUtils;

	@Override
	public Map<Integer, String> getAllRoles() {
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();

		List<RolesEntity> rolesList = (List<RolesEntity>)rolesRepo.findAll();
		rolesList.forEach(roleEntity -> {
			map.put(roleEntity.getRoleId(), roleEntity.getRoleName());
		});	
		return map;

	}

	@Override
	public boolean registerAccount(RegisterInfo info) {

		info.setActiveStatus("Locked");
		info.setPassword(PwdUtils.generateTempPwd(6));

		RegisterInfoEntity registerEntity = new RegisterInfoEntity();
		BeanUtils.copyProperties(info, registerEntity);
		RegisterInfoEntity savedEntity = registerRepository.save(registerEntity);
		if(savedEntity.getRegisterId() != null) {
			return emailUtils.sendUserAccUnlockEmail(info);
		}
		return false;
	}

	@Override
	public RegisterInfo getUserAcctByTempPwd(String tempPwd, String email) {
		RegisterInfoEntity entity = registerRepository.findByPasswordAndEmail(tempPwd,email);
		RegisterInfo info = null;
		if(entity!=null) {
			info = new RegisterInfo();
			BeanUtils.copyProperties(entity, info);
		}
		return info;
	}


	@Override
	public boolean updateUserInfo(RegisterInfo user) {
		RegisterInfoEntity entity = new RegisterInfoEntity();
		BeanUtils.copyProperties(user, entity);
		RegisterInfoEntity savedEntity = registerRepository.save(entity);
		return savedEntity!=null;
	}



	@Override
	public boolean loginWithEmailAndPwd(String email, String password) {
		RegisterInfo userInfo = new RegisterInfo();
		RegisterInfoEntity userEntity = registerRepository.findByEmailAndPassword(email, password);

		if(userEntity!=null) {
			BeanUtils.copyProperties(userEntity, userInfo);
			return true;
		} 
		return false;
	}



	@Override
	public List<RegisterInfo> getAllAccounts() {
		List<RegisterInfoEntity> entities = (List<RegisterInfoEntity>)registerRepository.findAll();
		List<RegisterInfo> allAccounts = new ArrayList<>();

		//leagacy approach
		for(RegisterInfoEntity entity : entities) {
			RegisterInfo account = new RegisterInfo();
			BeanUtils.copyProperties(entity, account);
			allAccounts.add(account);
		}
		return allAccounts;
	}
	
	
	@Override
	public RegisterInfo getAccountById(Integer id) {
		Optional<RegisterInfoEntity> findById = registerRepository.findById(id);
		if(findById.isPresent()) {
			RegisterInfoEntity accountEntity = findById.get();
			RegisterInfo account = new RegisterInfo();
			BeanUtils.copyProperties(accountEntity, account);
			return account;
		}
		return null;
	}


}
