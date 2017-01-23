package com.paularanas.ileg.web.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.paularanas.ileg.web.dao.UsersOnline;
import com.paularanas.ileg.web.service.UsersOnlineService;

@Controller
public class IlegController {

	private UsersOnlineService usersService;

	@Autowired
	public void setUsersService(UsersOnlineService usersService) {
		this.usersService = usersService;
	}

	@RequestMapping("/users")
	public String showUsers(Model model) {

		List<UsersOnline> currentUsers = usersService.getCurrentUser();
		model.addAttribute("users", currentUsers);

		return "users";
	}

	@RequestMapping("/createuser")
	public String createUser(Model model) {
		model.addAttribute("user", new UsersOnline());
		return "createuser";
	}

	@RequestMapping(value = "/docreate", method = RequestMethod.POST)
	public String doCreate(Model model, @Valid UsersOnline user, BindingResult result) {

		if (result.hasErrors()) {
			System.out.println("This form fails to validate.");

			List<ObjectError> validationErrors = result.getAllErrors();

			for (ObjectError error : validationErrors) {
				System.out.println(error.getDefaultMessage());
			}
			return "createuser";
		}
		usersService.createUser(user);
		
		return "usercreated";
	}
}
