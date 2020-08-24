package com.healthInsurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.healthInsurance.model.UserLogin;
import com.healthInsurance.service.RegisterInfoService;

@Controller
public class LoginController {

	@Autowired
	private RegisterInfoService service;

	@GetMapping("/login")
	public String loadLoginForm(Model model) {
		UserLogin userLogin = new UserLogin();
		model.addAttribute("userLogin", userLogin);
		return "Login";
	}

	@PostMapping(value="/login")
	public String handleLoginSubmit(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
		UserLogin userLogin = new UserLogin();
		model.addAttribute("userLogin",userLogin);
		boolean isValid = service.loginWithEmailAndPwd(email, password);
		if(isValid==true) {
			model.addAttribute("loginStatus", "Login Success");
			return "success";
		} else {
			model.addAttribute("loginStatus", "Invalid Credentials.Please Login again.");
			return  "Login";
		}
	}


	/*@GetMapping("/forgotPwd")
	public String forgotPwdPage(Model model) {
		ForgotForm forgotForm = new ForgotForm();
		model.addAttribute("forgotForm", forgotForm);
		return "ForgotPassword";
	}

	@PostMapping("/forgotPwd")
	public String forgotPwdPage(@RequestParam("email") String email,Model model) {
		System.out.println(email);
		model.addAttribute("email", email);
		UserInfo isExists = service.getUserByEmailForFogotPwd(email);
		System.out.println("*******Controller********");
		System.out.println(isExists);

		if(isExists!=null && isExists.getAccountStatus()=="Un-Locked") {
			boolean sendPwdToEmail = service.sendPwdToEmail(email);
			System.out.println("**********In Forgot Pwd***********");
			System.out.println(sendPwdToEmail);
		}

		ForgotForm forgotForm = new ForgotForm();
		model.addAttribute("forgotForm", forgotForm);		
		if(isExists==null) {
			model.addAttribute("emailExists", "Email is not registered");
			return "ForgotPassword";
		} else if(isExists.getAccountStatus()=="LOCKED") {
			model.addAttribute("emailExists", "Your account locked.Please unlock your account.");
			return "ForgotPassword";
		}	else{
			return "ForgotPasswordSuccess";
		}


		if(isExists.getAccountStatus() == "LOCKED") {
		model.addAttribute("lockStatus", "Your account locked.Please check your email to unlock.");
		return "ForgotPassword";
	}
	else {
		model.addAttribute("lockStatus", "Please proceed.");
		return "ForgotPasswordSuccess";
	}
		*//****Actaul code START*******//*
		*//****Actaul code STOP*******//*
		return "ForgotPasswordSuccess";

	}

	@PostMapping("/updatePwdforForgotPwd")
	@ResponseBody
	public String updatePwd(@ModelAttribute("forgotForm") ForgotForm forgotForm,@RequestParam("email") String email) {

		UserInfo userInfo = service.getUserByEmailForFogotPwd(email);
		userInfo.setEmail(email);
		userInfo.setPassword(forgotForm.getPwd());		

		System.out.println(userInfo);
		boolean isUpdated = service.updateUserInfo(userInfo);
		boolean isUpdated = service.updatePwdforForgotPwd(userInfo);

		System.out.println("Updated Successfully......"+isUpdated);
		return "Updated Successfully.Please Login";
	}
*/

}
