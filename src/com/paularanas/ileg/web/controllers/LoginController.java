package com.paularanas.ileg.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.paularanas.ileg.web.dao.User;

@Controller
public class LoginController {
	@RequestMapping("/loginpage")
	public String displayLoginPage(){
		
		return "loginpage";
		
	}
	
	@RequestMapping("/newaccount")
	public String displayNewAccount(Model model){
		model.addAttribute("user", new User());
		return "newaccount";
		
	}
	@RequestMapping("/establishaccount")
	public String establishAccount(){
		
		return "accountestablished";
		
	}
}
