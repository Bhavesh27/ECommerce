package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value="/delete-user-{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable int id)
	{
		userService.deleteUser(id);
		return "redirect:/admin";
		
	}
	
}
