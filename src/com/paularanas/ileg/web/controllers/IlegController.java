package com.paularanas.ileg.web.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.paularanas.ileg.web.dao.User;
import com.paularanas.ileg.web.service.UsersService;

@Controller
public class IlegController {
	
	private UsersService usersService;
	
	
	@Autowired
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}



	@RequestMapping("/")
	public String showHome(Model model) {
		
		List<User> currentUsers = usersService.getCurrentUser();
		model.addAttribute("users", currentUsers);

		return "home";
	}

}
