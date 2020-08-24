package com.healthInsurance.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.healthInsurance.model.RegisterInfo;
import com.healthInsurance.service.RegisterInfoService;

@Controller
public class RegisterInfoController {

	@Autowired
	private RegisterInfoService service;
	
	
	@GetMapping(value="/register")
	public String loadForm(ModelMap map) {
		RegisterInfo registerInfo = new RegisterInfo();
		map.addAttribute("registerInfo",registerInfo);
		Map<Integer, String> allRoles = service.getAllRoles();
		map.addAttribute("allRoles",allRoles);
		return "RegisterInfo";
	}
	
	@PostMapping(value="/saveAccount")
	public String registerAccount(@ModelAttribute("registerInfo") RegisterInfo info, ModelMap map) {
		boolean isSaved = service.registerAccount(info);
		if(isSaved) {
		map.addAttribute("successMsg", "User registered successfully.Please check your email to unlock.");
		return "RegisterInfo";
		} else {
		map.addAttribute("failedMsg", "User not registered");
		return "RegisterInfo";
		}
	}
	
	
	
	
}
