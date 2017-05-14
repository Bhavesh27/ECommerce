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
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.model.User;
import com.example.service.CategoryService;
import com.example.service.ProductService;
import com.example.service.UserService;
//import com.google.gson.Gson;

@Controller
public class HelloWorldController {

	
	@Autowired
	UserService userService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	/*@Autowired
	User user;*/
	
	Path path;
	
	
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	private String homePage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		model.addAttribute("categories", categoryService.getAllCategorys());
		model.addAttribute("products", productService.getAllProducts());
		model.addAttribute("Home", "activ");
		//System.out.println("dropdwown");
		return "welcome";
	}
	
	@RequestMapping(value = "/db", method = RequestMethod.GET)
	private String dbaPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "dba";
	}

	@RequestMapping(value = "/gotoadminsection", method = RequestMethod.GET)
	private String adminPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "redirect:/admin/dashboard";
	}
	
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	private String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
	}
	
	@RequestMapping(value="/account" , method = RequestMethod.GET)
	private String youtAccount(@RequestParam("username") String username , ModelMap model)
    {
    	model.addAttribute("categories", categoryService.getAllCategorys());
    	User user = userService.getUserByUsername(getPrincipal());
    	model.addAttribute("updateUser", user);
    	
    	return "userProfile";
    }
    
    @RequestMapping(value="/updatingAccount-{id}" , method = RequestMethod.POST)
    private String updateAccountDetails(@ModelAttribute("updateUser") User user , ModelMap model, HttpServletRequest request)
    {
    	user.setActive(true);
    		
    	userService.updateUser(user);
    	
    	MultipartFile image = user.getImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		
		path = Paths.get(rootDirectory + "/static/images/user/" + user.getUsername() + ".png");
		System.out.println(path.toString());
		if(image != null && !image.isEmpty() )
		{
			try{
				image.transferTo(new File(path.toString()));
			}catch(Exception exception){
				throw new RuntimeException("Product image Saved",exception);
			}
			
		}
    	model.addAttribute("msg", "Details have been successsfully updated");
    	return "redirect:/home";
    }
	
	@RequestMapping(value="/aboutUs", method = RequestMethod.GET)
	private String aboutUsPage(ModelMap model)
    {
    	model.addAttribute("Aboutus", "activ");
    	return "about_us";
    }
    
    @RequestMapping(value="/contactUs", method = RequestMethod.GET)
    private String contactUsPage(ModelMap model)
    {
    	model.addAttribute("Contactus", "activ");
    	return "contact_us";
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	private String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/Registration", method = RequestMethod.GET)
	private String registrationPage(Model model) {
		
		model.addAttribute("adduser", new User());
		return "Registration";
	}

	@RequestMapping(value= "/register", method = {RequestMethod.GET,RequestMethod.POST})
	private String addUser(@Valid @ModelAttribute("adduser") User user,HttpServletRequest request,BindingResult result,Model model){
		
		if(result.hasErrors()){
			return "Registration";
		}
		
		List<User> users = userService.getAllUsers();
		
		for(int i=0;i<users.size();i++)
		{
			if(user.getEmail().equals(users.get(i).getEmail())){
				model.addAttribute("Msg", "Email Already Exists");
				return "Registration";
			}
			
			if(user.getUsername().equals(users.get(i).getUsername())){
				model.addAttribute("Msg", "Username Already Exists");
				return "Registration";
			}
			
		}
		
		userService.addUser(user);
		
		MultipartFile image = user.getImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		
		path = Paths.get(rootDirectory + "/static/images/user/" + user.getUsername() + ".png");
		System.out.println(path.toString());
		if(image != null && !image.isEmpty() )
		{
			try{
				image.transferTo(new File(path.toString()));
			}catch(Exception exception){
				throw new RuntimeException("Product image Saved",exception);
			}
			
		}
		
		
		return "redirect:/userProfile";
		
	}

	/*@RequestMapping(value = "/registrationSuccess", method = RequestMethod.GET)

	public String registrationSuccess(Model model,Principal principal) {
		
		String name=principal.getName();
		model.addAttribute("userName", name);
		return "RegistrationSuccess";
	}*/
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	private String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	
	
	public String getPrincipal(){
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