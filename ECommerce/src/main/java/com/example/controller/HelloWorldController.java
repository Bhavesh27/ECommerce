package com.example.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

//import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.example.model.User;
import com.example.service.UserService;

@Controller
public class HelloWorldController {

	
	@Autowired
	UserService userService;
	
	/*@Autowired
	User user;*/
	
	Path path;
	
	
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "welcome";
	}
	
	@RequestMapping(value = "/db", method = RequestMethod.GET)
	public String dbaPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "dba";
	}

	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/Registration", method = RequestMethod.GET)
	public String registrationPage(Model model) {
		
		model.addAttribute("adduser", new User());
		return "Registration";
	}

	@RequestMapping(value= "/register", method = {RequestMethod.GET,RequestMethod.POST})
	public String addUser(@Valid @ModelAttribute("adduser") User user,HttpServletRequest request,BindingResult result,Model model){
		
		if(result.hasErrors()){
			return "Registration";
		}
		
		List<User> users = userService.getAllUsers();
		
		for(int i=0;i<users.size();i++)
		{
			if(user.getEmail().equals(users.get(i).getEmail())){
				model.addAttribute("emailMsg", "Email Already Exists");
				return "Registration";
			}
			
			if(user.getUsername().equals(users.get(i).getUsername())){
				model.addAttribute("usernameMsg", "Username Already Exists");
				return "Registration";
			}
			
			if(user.getMobileno().equals(users.get(i).getMobileno())){
				model.addAttribute("mobilenoMsg", "MobileNo Already Exists");
				return "Registration";
			}
		}
		
		userService.addUser(user);
		
		MultipartFile image = user.getImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		
		path = Paths.get(rootDirectory + "/static/images/user" + user.getUsername() + ".png");
		System.out.println(path.toString());
		if(image != null && !image.isEmpty() )
		{
			try{
				image.transferTo(new File(path.toString()));
			}catch(Exception exception){
				throw new RuntimeException("Product image Saved",exception);
			}
			
		}
		
		
		return "redirect:/login";
		
	}

	/*@RequestMapping(value = "/registrationSuccess", method = RequestMethod.GET)

	public String registrationSuccess(Model model,Principal principal) {
		
		String name=principal.getName();
		model.addAttribute("userName", name);
		return "RegistrationSuccess";
	}*/
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	
	
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

}