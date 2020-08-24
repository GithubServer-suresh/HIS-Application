package com.healthInsurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.healthInsurance.model.RegisterInfo;
import com.healthInsurance.model.UnlockAccount;
import com.healthInsurance.service.RegisterInfoService;

@Controller
public class UnlockAccountController {

	@Autowired
	private RegisterInfoService userService;


	@GetMapping(value = "/unlockAcc")
	public String displayUnlockAccForm(@RequestParam("email") String email, Model model) {
		
		UnlockAccount unlockAcc = new UnlockAccount();
		unlockAcc.setEmail(email);
		model.addAttribute("unlockAcc", unlockAcc);

		return "unlockAccForm";
	}

	@PostMapping("/unlockUserAcc")
	public String unlockUserAcc(@ModelAttribute("unlockAcc") UnlockAccount acc, Model model) {
		System.out.println(acc);
		RegisterInfo registerInfo = userService.getUserAcctByTempPwd(acc.getTempPwd(),acc.getEmail());
		if(registerInfo!=null) {
			registerInfo.setActiveStatus("Un-Locked");
			registerInfo.setPassword(acc.getNewPwd());
			boolean isUpdated = userService.updateUserInfo(registerInfo);
			if(isUpdated) {
				return "unlockAccntSuccess";
			}
		}
		model.addAttribute("errMsg", "Please enter correct Temporary Password");
		return "unlockAccForm";
	}


}
