package com.paularanas.ileg.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.paularanas.ileg.web.dao.User;
import com.paularanas.ileg.web.dao.UsersOnline;
import com.paularanas.ileg.web.service.UsersOnlineService;
import com.paularanas.ileg.web.service.UsersService;

@Controller
public class LoginController {
	
	
	private UsersService usersService;

	@Autowired
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}
	@RequestMapping("/loginpage")
	public String displayLoginPage(){
		
		return "loginpage";
		
	}
	@RequestMapping("/loggedout")
	public String displayLoggedoutPage(){
		
		return "loggedout";
		
	}
	@RequestMapping("/newaccount")
	public String displayNewAccount(Model model){
		model.addAttribute("user", new User());
		return "newaccount";
		
	}

	
	@RequestMapping(value = "/establishaccount", method = RequestMethod.POST)
	public String establishAccount(@Valid User user, BindingResult result) {

		if (result.hasErrors()) {
			System.out.println("This form fails to validate.");
			user.setEnabled(true);
			user.setAuthority("user");
			List<ObjectError> validationErrors = result.getAllErrors();

			for (ObjectError error : validationErrors) {
				System.out.println(error.getDefaultMessage());
			}
			return "newaccount";
		}
		if (usersService.exists(user.getUsername())){
			result.rejectValue("username", "KeyDuplicated.user.username", "Username is taken!" );
			return "newaccount";		
		}
		try{
		usersService.createUser(user);
		} catch (DuplicateKeyException e){
			result.rejectValue("username", "KeyDuplicated.user.username", "Username is taken!" );
			return "newaccount";
		}
		
		return "accountestablished";
	}
}
