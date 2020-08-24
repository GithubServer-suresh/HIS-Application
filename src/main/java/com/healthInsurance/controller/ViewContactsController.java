package com.healthInsurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.healthInsurance.model.RegisterInfo;
import com.healthInsurance.service.RegisterInfoService;


@Controller
public class ViewContactsController {

	@Autowired
	private  RegisterInfoService registerService;
	
	@GetMapping("/viewAccounts")
	public String handleViewContactLink(Model model) {
		List<RegisterInfo> accountsList = registerService.getAllAccounts();
		model.addAttribute("accountsList", accountsList);
		return "viewAccounts";
	}
	
	@RequestMapping("/editAccount")
	public String editContact(@RequestParam("accId")  Integer accountId, Model model) {
		RegisterInfo registerInfo = new RegisterInfo();
		model.addAttribute("registerInfo", registerInfo);
		RegisterInfo account = registerService.getAccountById(accountId);
		model.addAttribute("account", account);
		System.out.println(account);
		return "accountInfo";
	}
	
	/*
	@GetMapping("/deleteAccount")
	public String deleteContact(@RequestParam("accId") Integer contactId) {
		boolean isDeleted = contactService.deleteContact(contactId);
		if(isDeleted) {
			return "redirect:viewContacts";
		}
		return null;
	}*/
	
}
